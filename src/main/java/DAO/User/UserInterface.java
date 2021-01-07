package DAO.User;

import Entities.User;

public interface UserInterface {
    void create(User user);
    User find(User user);
    void remove();
    void update();
}
