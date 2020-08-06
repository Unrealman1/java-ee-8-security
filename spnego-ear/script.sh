#!/bin/bash

# Usage: execute.sh [WildFly mode] [configuration file]
#
# The default mode is 'standalone' and default configuration is based on the
# mode. It can be 'standalone.xml' or 'domain.xml'.

JBOSS_CLI=$JBOSS_HOME/bin/jboss-cli.sh
JBOSS_MODE=${1:-"standalone"}
JBOSS_CONFIG=${2:-"$JBOSS_MODE.xml"}

echo $JBOSS_HOME - working dir

function wait_for_server() {
  until `$JBOSS_CLI -c ":read-attribute(name=server-state)" 2> /dev/null | grep -q running`; do
    sleep 1
  done
}

echo "=> Starting WildFly server"
$JBOSS_HOME/bin/$JBOSS_MODE.sh -b 0.0.0.0 -c $JBOSS_CONFIG &

echo "=> Waiting for the server to boot"
wait_for_server

$JBOSS_CLI -c << EOF
batch

deploy /opt/postgresql-42.2.14.jar
data-source add --name=examplePostgresDS --jndi-name=java:jboss/datasources/ProcessEngine --driver-name=postgresql-42.2.14.jar  --connection-url=jdbc:postgresql://192.168.0.188:5432/camunda --user-name=camunda --password=camunda

# Execute the batch
run-batch
EOF