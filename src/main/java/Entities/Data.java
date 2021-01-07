package Entities;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="data")
@NamedQueries(
        {
                @NamedQuery(name= Data.GET_BY_USERNAME,query = Data.GET_BY_USERNAME_QUERY),
                @NamedQuery(name= Data.DELETE_BY_USERNAME,query = Data.DELETE_BY_USERNAME_QUERY)
        }
)
@Entity
public class Data {
    public static final String GET_BY_USERNAME = "GET_BY_USERNAME";
    static final String GET_BY_USERNAME_QUERY = "SELECT data from Data data where data.user = :user";

    public static final String DELETE_BY_USERNAME = "DELETE_BY_USERNAME";
    static final String DELETE_BY_USERNAME_QUERY = "DELETE from Data data where data.user = :user";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;
    private Double X = 0d;
    private String Y;
    private Double R = 1d;
    private String result;
    private String time;

    public User getUser(){return user;}

    public Long getId() {
        return id;
    }
    public Data(){}

    public String getResult() {return result;}
    public String getTime() {return time;}
    public Double getX() {return X;}
    public String getY() {return Y;}
    public Double getR() {return R;}

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setR(Double r) {R = r;}
    public void setX(Double x) {X = x;}
    public void setY(String y) {Y = y;}

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
