import org.wildfly.security.authz.AuthorizationIdentity;
import org.wildfly.security.authz.RoleDecoder;
import org.wildfly.security.authz.Roles;

public class CustomRoleDecoder implements RoleDecoder {

    @Override
    public Roles decodeRoles(AuthorizationIdentity authorizationIdentity) {
    return Roles.of("ADMIN");
    }
}
