package service.ifc;

import entity.Token;
import entity.User;

public interface TokenService {
    Token createToken(User user);
    void deleteToken(String key);
}
