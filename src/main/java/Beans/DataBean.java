package Beans;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;

import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Stateless
public class DataBean {
    public DataBean(){}
//    @Path("/checkXYR")
//    @POST
//    public void checkXYR(@FormParam("x") double x, @FormParam("y") double y, @FormParam("r") double r, @Context HttpRequest request, @Context HttpResponse response){
//
//
//    }
}
