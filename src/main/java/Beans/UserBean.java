package Beans;

import DAO.User.UserInterface;
import Entities.Data;
import Entities.User;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.ArrayList;

@Path("/usr")
@ApplicationPath("/zhopa")
public class UserBean {
    @EJB
    UserInterface userInterface;
    @Path("/signup")
    @POST
    public void addUser(@FormParam("name") String name, @FormParam("surname") String surname, @FormParam("login") String login, @FormParam("password") String password, @FormParam("mail") String email, @Context HttpServletResponse resp, @Context HttpServletRequest req) {
        try {
            User usr = new User(login, password,new ArrayList<Data>());
            userInterface.create(usr);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("shots", new ArrayList<Data>());
            resp.sendRedirect("http://localhost:3377/laba4-1.0/check.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Path("/login")
//    @POST
//    public void check(@FormParam("login") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req) {
//
//
//    }
    @Path("/logout")
    @POST
    public void logOut(@Context HttpServletRequest req, @Context HttpServletResponse resp) {
        try {
            req.getSession().invalidate();
            resp.sendRedirect("http://localhost:5432/index.html");
        } catch (Exception ignored) {
        }
    }
    //http://localhost:8080/demo/zhopa/usr/hellowrld
    @Path("/hellowrld")
    @GET
    public String helloWrld(){
        return "Hello";
    }
}
