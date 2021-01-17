package PersistenceLayer.Token;

import BusinessLayer.Entities.Token.UserToken;

public interface TokenInterface {
    void create(UserToken userToken);
    void delete(String userToken);
    UserToken find(String userToken);
}
