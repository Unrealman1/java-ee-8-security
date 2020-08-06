package itu;


import org.jboss.ejb3.annotation.SecurityDomain;

import javax.ejb.Stateless;

@Stateless
@SecurityDomain("other")
public class ServiceEJB {
    public String getMessage(){
        return "From Ejb Module";
    }
}
