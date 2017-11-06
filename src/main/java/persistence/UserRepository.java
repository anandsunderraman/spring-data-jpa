package persistence;

import model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.Repository;

import java.util.Set;


public interface UserRepository extends Repository<User, Long> {
      Set<User> findAll();

      @EntityGraph(value = "userWithDepartment", type = EntityGraph.EntityGraphType.LOAD)
      User findById(Integer id);

      @EntityGraph(value = "userWithAddress", type = EntityGraph.EntityGraphType.LOAD)
      User findByName(String name);
}
