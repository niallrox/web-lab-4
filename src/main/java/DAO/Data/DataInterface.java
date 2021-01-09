package DAO.Data;

import Entities.Data;
import Entities.User;

import javax.ejb.Local;
import java.util.List;
@Local
public interface DataInterface {
    void create(Data data);
    Data find(Data data);
    void remove();
    void update();
    List<Data> findAll(User user);
}
