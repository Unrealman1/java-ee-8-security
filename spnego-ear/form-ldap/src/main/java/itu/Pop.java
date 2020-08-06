package itu;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.security.Principal;

@WebServlet("/hoho")
public class Pop extends HttpServlet {

    @Context
    protected SecurityContext securityContext;

    @Inject
    private ServiceTest service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("hoho\n");
       resp.getWriter().append( req.getUserPrincipal().getName());
       resp.getWriter().append(service.getMessage());
    }
}
