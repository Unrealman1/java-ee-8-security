package itu;


import org.jboss.ejb3.annotation.SecurityDomain;

import javax.ejb.Stateless;

@Stateless
//@SecurityDomain("other")
public class Service {
    public String getMessage(){
        return "Yay from Ejb";
    }
}
