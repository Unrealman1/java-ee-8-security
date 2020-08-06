package itu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("api")
public class Controller {

    @Context
    protected SecurityContext securityContext;

    @GET
    @Path("a")
    public String gg(){
        return securityContext.getUserPrincipal().getName();
    }
}
