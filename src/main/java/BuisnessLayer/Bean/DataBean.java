package BuisnessLayer.Bean;

import BuisnessLayer.Entities.Data;

import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful
public class DataBean {
    private ArrayList<Data> points =new ArrayList<Data>();

    public ArrayList<Data> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Data> points) {
        this.points = points;
    }
}
