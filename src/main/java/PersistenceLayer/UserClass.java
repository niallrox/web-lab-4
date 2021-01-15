package PersistenceLayer;

import BusinessLayer.Entities.User;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Singleton
public class UserClass implements UserInterface {
    @PersistenceContext(unitName = "exampleDS")
    private EntityManager entityManager;

    @Override
    public void create(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public User find(String name) {
        return entityManager.find(User.class, name);
    }

    @Override
    public void remove() {
        //
    }

    @Override
    public boolean checkUser(String login, String password) throws NoResultException {
        try {
            User usr = entityManager.find(User.class, login);
            if (!(usr == null)) {
                return password.hashCode() == usr.getPass();
            }
            return false;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
