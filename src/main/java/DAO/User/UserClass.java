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
    private EntityManager entityManager;
    @Override
    public void create(User entity) {
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.persist(entity);

    }

    @Override
    public User find(User entity) {
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(User.class,entity.getName());
    }

    @Override
    public void remove() {
        //
    }

    @Override
    public boolean assertUser(String login, String password) throws NoResultException {
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
//            User usr = (User) entityManager.createQuery("from User where name = :name").setParameter("name", login).getSingleResult();
            User usr = entityManager.find(User.class,login);
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
