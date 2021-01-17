package PersistenceLayer.Token;

import BusinessLayer.Entities.Token.UserToken;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Singleton
public class TokenClass implements TokenInterface {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void create(UserToken userToken) {
        if(entityManager.find(UserToken.class,userToken.getName())==null) entityManager.persist(userToken);
    }

    @Override
    public void delete(String token) {
        UserToken userToken = new UserToken(token);
        entityManager.remove(userToken);
    }

    @Override
    public UserToken find(String token) {
        return entityManager.find(UserToken.class,token);
    }
}
