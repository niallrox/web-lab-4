package DAO.Data;

import Entities.Data;
import Entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class DataClass implements DataInterface {
    @PersistenceContext(unitName = "exampleDS")
    private EntityManager entityManager;
    @Override
    public void create(Data entity) {
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.persist(entity);

    }

    @Override
    public Data find(Data entity) {
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
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
            return  (List<Data>) entityManager.createQuery("select a from Data a").getResultList();
    }


}
