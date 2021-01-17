package BusinessLayer.Entities.User;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String name;
    private String pass;
    public UserDto(){}

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
