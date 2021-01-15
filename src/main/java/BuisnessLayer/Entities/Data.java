package BuisnessLayer.Entities;

import javax.persistence.*;


@Table(name="data")
@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double X = 0d;
    private Double Y;
    private Double R = 1d;
    private boolean result;


    public Long getId() {
        return id;
    }
    public Data(){}
    public Data(double x,double y,double r){
        this.X=x;
        this.Y=y;
        this.R=r;
    }

    public boolean getResult() {return result;}
    public Double getX() {return X;}
    public Double getY() {return Y;}
    public Double getR() {return R;}


    public void setId(Long id) {
        this.id = id;
    }

    public void setR(Double r) {R = r;}
    public void setX(Double x) {X = x;}
    public void setY(Double y) {Y = y;}


    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "X=" + X +
                ", Y='" + Y + '\'' +
                ", R=" + R +
                ", result='" + result + '\'' +
                '}';
    }
}
