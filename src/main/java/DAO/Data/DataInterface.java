package DAO.Data;

import Entities.Data;
import Entities.User;

import java.util.List;

public interface DataInterface {
    void create(Data data);
    Data find(Data data);
    void remove();
    void update();
    List<Data> findAll(User user);
}
