package WebLayer;

import BuisnessLayer.Bean.DataBean;
import BuisnessLayer.Entities.Data;
import BuisnessLayer.Manager.Controller;
import PersistenceLayer.UserInterface;
import BuisnessLayer.Entities.User;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;


@Path("/usr")
public class UserBean {
    @EJB
    UserInterface userInterface;
    @EJB
    DataBean dataBean;
    @EJB
    Controller controller;

    @POST
    @Path("/create")
    public Response create(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) {
        User usr = new User(username, password);
        if (userInterface.find(usr) == null) {
            userInterface.create(usr);
            return Response.ok(usr.getName()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/login")
    @POST
    public Response check(@FormParam("username") String login, @FormParam("password") String password)  {
        boolean check = userInterface.assertUser(login, password);
        if (check) {
            return Response.ok(login).build();
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
    @Path("/addPoint")
    @POST
    public Response addPoint(@FormParam("x") String x, @FormParam("y") String y, @FormParam("r") String r) {
        dataBean.getPoints().add(controller.parseData(x,y,r));
        return Response.ok(dataBean.getPoints()).build();
    }

    //  http://localhost:8080/demo-1.0-SNAPSHOT/rest/usr/helloworld
    @Path("/helloworld")
    @GET
    public String helloWorld() {
        return "Hello World";
    }
}
