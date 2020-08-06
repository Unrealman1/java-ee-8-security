FROM camunda/camunda-bpm-platform:wildfly-7.13.0
EXPOSE 8080 8000 9404 9990
#COPY modules/ /camunda/modules/
#ADD startcontainer.sh /camunda/
USER root
#RUN chown camunda:camunda /camunda/startcontainer.sh
#RUN chmod +x /camunda/startcontainer.sh
USER camunda
RUN /camunda/bin/add-user.sh -u 'admin1' -p '!qaz2wsx'
#CMD ["/camunda/startcontainer.sh"]