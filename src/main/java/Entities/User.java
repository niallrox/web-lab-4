package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String name;
    private int pass;
    @OneToMany
    private List<Data> dots;

    public User() {}
    public User(String name,String pass,List<Data> dots) {
        this.name=name;
        this.pass=pass.hashCode();
        this.dots=dots;
    }

    public void setName(String name){this.name=name;}
    public void setPass(int pass){this.pass=pass;}

    public void setDots(List<Data> dots) {
        this.dots = dots;
    }

    public String getName(){return name;}
    public int getPass(){return pass;}

    public List<Data> getDots() {
        return dots;
    }
}
