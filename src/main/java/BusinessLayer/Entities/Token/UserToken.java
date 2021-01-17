package BusinessLayer.Entities.Token;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;

@Entity
@Table(name = "Token")
public class UserToken {
    @Id
    private String token;
    private String name;

    public UserToken(){};
    public UserToken(String name){
        this.name=name;
        this.token=DigestUtils.md5Hex(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }
    public String getToken() {
        return token;
    }
}
