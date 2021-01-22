package PersistenceLayer.Token;

import BusinessLayer.Entities.Token.UserToken;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Singleton
public class TokenClass implements TokenInterface {
    @PersistenceContext(unitName = "jjDS")
    private EntityManager entityManager;

    @Override
    public void create(UserToken userToken) {
        if (entityManager.find(UserToken.class, userToken.getName()) == null) entityManager.persist(userToken);
    }

    @Override
    public void delete(String token) {
        entityManager.createQuery("DELETE from UserToken token where token.token = :token").setParameter("token", token).executeUpdate();
    }

    @Override
    public UserToken find(String token) {
        return entityManager.find(UserToken.class, token);
    }
}
