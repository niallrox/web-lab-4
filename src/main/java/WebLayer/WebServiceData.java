package WebLayer;

import BusinessLayer.Entities.Data.Data;
import BusinessLayer.Entities.Data.DataDto;
import BusinessLayer.Entities.Token.UserToken;
import BusinessLayer.Entities.User.User;
import BusinessLayer.Manager.Controller;
import PersistenceLayer.Token.TokenInterface;
import PersistenceLayer.User.UserInterface;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/points")
public class WebServiceData {
    @EJB
    UserInterface userInterface;
    @EJB
    Controller controller;
    @EJB
    TokenInterface tokenInterface;

    @POST
    @NeededLogin
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPoint(@HeaderParam("Authorization") String authorization, DataDto dataDto) {
        try {
            User user = userInterface.find(tokenInterface.find(authorization.substring(1,authorization.length()-1)).getName());
            Data data = controller.parseData(dataDto.getX(), dataDto.getY(), dataDto.getR());
            user.addToPoints(data);
            userInterface.update(user);
            return Response.ok(data).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @NeededLogin
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoints(@HeaderParam("Authorization") String authorization) {
        try {
            User user = userInterface.find(tokenInterface.find(authorization.substring(1,authorization.length()-1)).getName());
            return Response.ok(user.getPoints()).build();
        } catch (Exception exception) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @NeededLogin
    @DELETE
    public Response clearPoints(@HeaderParam("Authorization") String authorization) {
        UserToken usr = tokenInterface.find(authorization.substring(1,authorization.length()-1));
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
