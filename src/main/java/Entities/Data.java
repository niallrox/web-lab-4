package Entities;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="data")
@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double X = 0d;
    private Double Y;
    private Double R = 1d;
    private String result;
    private String time;


    public Long getId() {
        return id;
    }
    public Data(){}
    public Data(double x,double y,double r){
        this.X=x;
        this.Y=y;
        this.R=r;
    }

    public String getResult() {return result;}
    public String getTime() {return time;}
    public Double getX() {return X;}
    public Double getY() {return Y;}
    public Double getR() {return R;}


    public void setId(Long id) {
        this.id = id;
    }

    public void setR(Double r) {R = r;}
    public void setX(Double x) {X = x;}
    public void setY(Double y) {Y = y;}

    public void setTime(String time) {
        this.time = time;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "X=" + X +
                ", Y='" + Y + '\'' +
                ", R=" + R +
                ", result='" + result + '\'' +
                ", time='" + time + '\'' +
                ", session='" + '\'' +
                '}';
    }
}
