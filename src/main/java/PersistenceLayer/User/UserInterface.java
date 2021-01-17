package PersistenceLayer.User;

import BusinessLayer.Entities.User.User;

public interface UserInterface {
    void create(User user);
    User find(String name);
    void remove();
    void update(User user);
    boolean checkUser(String login,String password);
}
