package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String name;
    private int pass;


    public User() {}
    public User(String name,String pass) {
        this.name=name;
        this.pass=pass.hashCode();
    }

    public void setName(String name){this.name=name;}
    public void setPass(int pass){this.pass=pass;}


    public String getName(){return name;}
    public int getPass(){return pass;}


}
