package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String name;
    private String pass;

    public User() { }
    public User(String username,String usrPass){
        name=username;
        pass=usrPass;
    }

    public void setName(String name){this.name=name;}
    public void setPass(String pass){this.pass=pass;}
    public String getName(){return name;}
    public String getPass(){return pass;}
}
