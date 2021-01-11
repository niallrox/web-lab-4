package DAO.User;

import Entities.User;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
@Stateful
public class UserClass implements UserInterface {
    @PersistenceContext(unitName = "exampleDS")
    private EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Override
    public void create(User entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User find(User entity) {
        entityManager.getTransaction().begin();
        return entityManager.find(User.class,entity.getName());
    }

    @Override
    public void remove() {
        //
    }

    @Override
    public boolean assertUser(String login, String password) throws NoResultException {
        try {
            User usr = (User) entityManager.createQuery("from User where name = :name").setParameter("name", login).getSingleResult();
            if (!(usr == null)) {
                return password.hashCode() == usr.getPass();
            }
            return false;
        }catch (NoResultException e){return false;}
    }

    @Override
    public void update() {
        //
    }
}
