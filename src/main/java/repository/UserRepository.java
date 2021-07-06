package repository;

import entity.Point;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "from Point p where p.userId = (:id)")
    List<Point> findAllPointsByUserID(String id);

    @Query("delete from Point p where p.userId=(:id)")
    void removeAllPointsByUserID(String id);
}
