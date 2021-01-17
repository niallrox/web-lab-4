package BusinessLayer.Entities.User;

import BusinessLayer.Entities.Data.Data;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String name;
    private String pass;

    @OneToMany(fetch = FetchType.EAGER ,
            cascade = CascadeType.ALL)
    private List<Data> points = new ArrayList<>();

    public void addToPoints(Data data) {
        this.points.add(data);
    }
    public void clearPoints() {
        this.points.clear();
    }

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = DigestUtils.md5Hex(name+pass);
    }

    public List<Data> getPoints() {
        return points;
    }

    public void setPoints(List<Data> points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

}
