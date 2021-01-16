package WebLayer;

import BusinessLayer.Entities.Data;
import BusinessLayer.Entities.User;
import BusinessLayer.Manager.Controller;
import PersistenceLayer.UserInterface;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/usr")
public class WebService {
    @EJB
    UserInterface userInterface;
    @EJB
    Controller controller;

    @POST
    @Path("/create")
    public Response create(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) {
        User usr = new User(username, password);
        if (userInterface.find(username) == null) {
            ArrayList<Data> data = new ArrayList<>();
            usr.setPoints(data);
            userInterface.create(usr);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/login")
    @POST
    public Response check(@FormParam("username") String login, @FormParam("password") String password) {
        boolean check = userInterface.checkUser(login, password);
        if (check) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/logout")
    @GET
    public Response logOut(@Context HttpServletRequest req) {
        req.getSession().invalidate();
        return Response.ok().build();
    }

    //  http://localhost:8080/demo-1.0-SNAPSHOT/rest/usr/helloworld
    @Path("/helloworld")
    @GET
    public String helloWorld() {
        return "Hello World";
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addPoint")
    @POST
    public Response addPoint(@FormParam("name") String username, @FormParam("x") String x, @FormParam("y") String y, @FormParam("r") String r) {
        User user = userInterface.find(username);
        if (user != null) {
            Data data = controller.parseData(x, y, r);
            user.addToPoints(data);
            userInterface.update(user);
            return Response.ok(data).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getPoints")
    @POST
    public Response getPoints(@FormParam("name") String username) {
        User user = userInterface.find(username);
        if (user != null) {
            return Response.ok(user.getPoints()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/clear")
    @POST
    public Response clearPoints(@FormParam("name") String username) {
        User user = userInterface.find(username);
        if (user != null) {
            user.clearPoints();
            userInterface.update(user);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}