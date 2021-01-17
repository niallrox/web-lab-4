package WebLayer;

import BusinessLayer.Entities.Data.Data;
import BusinessLayer.Entities.User.User;
import BusinessLayer.Entities.User.UserDto;
import BusinessLayer.Entities.Token.UserToken;
import BusinessLayer.Manager.Controller;
import PersistenceLayer.Token.TokenInterface;
import PersistenceLayer.User.UserInterface;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/usr")
public class WebServiceUser {
    @EJB
    UserInterface userInterface;
    @EJB
    TokenInterface tokenInterface;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(UserDto userDto) {
        if (userInterface.find(userDto.getName()) == null && userDto.getName().trim().length()!=0 && userDto.getPass().trim().length()!=0) {
            User usr = new User(userDto.getName(), userDto.getPass());
            ArrayList<Data> data = new ArrayList<>();
            usr.setPoints(data);
            userInterface.create(usr);
            UserToken userToken = new UserToken(userDto.getName());
            tokenInterface.create(userToken);
            return Response.ok(userToken.getToken()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response check(UserDto userDto) {
        boolean check = userInterface.checkUser(userDto.getName(), userDto.getPass());
        if (check) {
            UserToken userToken = new UserToken(userDto.getName());
            tokenInterface.create(userToken);
            return Response.ok(userToken.getToken()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/logout")
    @GET
    public Response logOut(@HeaderParam("Authorization") String authorization) {
        tokenInterface.delete(authorization);
        return Response.ok().build();
    }

    //  http://localhost:8080/demo-1.0-SNAPSHOT/rest/usr/helloworld
    @Path("/helloworld")
    @GET
    public String helloWorld() {
        return "HelloWorld";
    }
}