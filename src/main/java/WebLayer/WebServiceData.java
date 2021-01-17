package WebLayer;

import BusinessLayer.Entities.Data.Data;
import BusinessLayer.Entities.Token.UserToken;
import BusinessLayer.Entities.User.User;
import BusinessLayer.Manager.Controller;
import PersistenceLayer.Token.TokenInterface;
import PersistenceLayer.User.UserInterface;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data")
public class WebServiceData {
    @EJB
    UserInterface userInterface;
    @EJB
    Controller controller;
    @EJB
    TokenInterface tokenInterface;

    @NeededLogin
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addPoint")
    @POST
    public Response addPoint(@HeaderParam("Authorization") String authorization, @FormParam("x") String x, @FormParam("y") String y, @FormParam("r") String r) {
        UserToken usr = tokenInterface.find(authorization);
        if (usr != null) {
            User user = userInterface.find(usr.getName());
            Data data = controller.parseData(x, y, r);
            user.addToPoints(data);
            userInterface.update(user);
            return Response.ok(data).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @NeededLogin
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getPoints")
    @GET
    public Response getPoints(@HeaderParam("Authorization") String authorization) {
        UserToken usr = tokenInterface.find(authorization);
        if (usr != null) {
            User user = userInterface.find(usr.getName());
            return Response.ok(user.getPoints()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @NeededLogin
    @Path("/clear")
    @DELETE
    public Response clearPoints(@HeaderParam("Authorization") String authorization) {
        UserToken usr = tokenInterface.find(authorization);
        if (usr != null) {
            User user = userInterface.find(usr.getName());
            user.clearPoints();
            userInterface.update(user);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
