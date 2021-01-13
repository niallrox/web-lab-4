package Beans;

import DAO.User.UserInterface;
import Entities.Data;
import Entities.User;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.ArrayList;

@Path("/usr")
public class UserBean {
    @EJB
    UserInterface userInterface;
    @Path("/signup")
    @POST
    public void addUser(@FormParam("username") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req) throws IOException {
        try {
            User usr = new User(login, password);
            userInterface.create(usr);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("shots", new ArrayList<Data>());
            resp.sendRedirect("http://localhost:3000");
        } catch (Exception e) {
            resp.sendError(404,"ХУЕСОСССССООСОСОС");
        }
    }

    @Path("/login")
    @POST
    public void check(@FormParam("username") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req) throws IOException {
        boolean check = userInterface.assertUser(login, password);
        if (check) {
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("shots", new ArrayList<Data>());
            resp.sendRedirect("http://localhost:3000");
        } else {
            resp.sendRedirect("http://localhost:3377/laba4-1.0/error_page.html");
        }
    }
    @Path("/logout")
    @POST
    public void logOut(@Context HttpServletRequest req, @Context HttpServletResponse resp) {
        try {
            req.getSession().invalidate();
            resp.sendRedirect("http://localhost:3000/login");
        } catch (Exception ignored) {
        }
    }
//  http://localhost:8080/demo-1.0-SNAPSHOT/rest/usr/helloworld
    @Path("/helloworld")
    @GET
    public String helloWorld(){
        return "Hello World";
    }
}
