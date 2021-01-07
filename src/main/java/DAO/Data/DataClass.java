package DAO.Data;

import Entities.Data;
import Entities.User;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateful
public class DataClass implements DataInterface {
    @PersistenceContext(unitName = "exampleDS")
    private EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Override
    public void create(Data entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Data find(Data entity) {
        entityManager.getTransaction().begin();
        return entityManager.find(Data.class,entity.getId());
    }

    @Override
    public void remove() {
        //
    }

    @Override
    public void update() {
        //
    }

    @Override
    public List<Data> findAll(User user) {
        return entityManager.createNamedQuery(Data.GET_BY_USERNAME,Data.class).setParameter("user",user).getResultList();
    }


}
