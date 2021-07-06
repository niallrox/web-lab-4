package service.ifc;

import entity.Point;
import entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User authorize(User user);
    List<Point> getAllPointsByUserId(String id);
    void removeAllPoints(String id);
}
