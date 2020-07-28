package repos;

import modelDB.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);

    List<User> findByActive(boolean active);

    User findById(int id);
}
