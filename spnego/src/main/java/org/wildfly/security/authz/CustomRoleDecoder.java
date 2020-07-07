package org.wildfly.security.authz;

public class CustomRoleDecoder implements RoleDecoder {

    @Override
    public Roles decodeRoles(AuthorizationIdentity authorizationIdentity) {
        return Roles.of("ADMIN");
    }
}
