package Beans;

import DAO.Data.DataInterface;
import Entities.Data;
import Entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.util.List;

@Stateful
@Path("/data")
public class DataBean {
    @EJB
    private DataInterface dataClass;
    @PostConstruct
    public void go() {
        System.out.println("vyfuyg");
        Data data = new Data();
        data.setId(1L);
        data.setX(2.0);
        data.setY(2.1);
        data.setR(2.1);
        data.setResult("True");
        dataClass.create(data);
    }
    public boolean checkXYR(double x,double y,double r) {
        //triangle
        if (x <= 0 && x >= -r && y <= 0 && y >= -r * 0.5 && y >= (-0.5 * x - 0.5 * r)) {
            return true;
        }
        //rectangle
        else if (x <= 0 && x >= -0.5 * r && y >= 0 && y <= r) {
            return true;
        }
        //ring
        else if (x >= 0 && y <= 0 && (x * x + y * y) <= r * r / 4) {
            return true;
        } else return false;
        //hate simplifies
    }
    @Path("/addPoint")
    @POST
    public void addPoint(@FormParam("x") double x, @FormParam("y") double y, @FormParam("r") double r, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        Data data = new Data(x,y,r);
        data.setResult(String.valueOf(checkXYR(x, y, r)));
        ((List<Data>) request.getSession().getAttribute("data")).add(data);
        dataClass.create(data);
    }
}
