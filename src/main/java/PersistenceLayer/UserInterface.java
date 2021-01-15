package PersistenceLayer;

import BuisnessLayer.Entities.User;

public interface UserInterface {
    void create(User user);
    User find(User user);
    void remove();
    void update();
    boolean assertUser(String login,String password);
}
