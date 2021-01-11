package DAO.Data;

import Entities.Data;
import Entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class DataClass implements DataInterface {
    @PersistenceContext(unitName = "exampleDS")
    private EntityManager entityManager;
    @Override
    public void create(Data entity) {
        entityManager.persist(entity);
    }

    @Override
    public Data find(Data entity) {
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
//        return entityManager.createNamedQuery(Data.GET_BY_USERNAME,Data.class).setParameter("user",user).getResultList();
        return null;
    }


}
