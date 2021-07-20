package springboot.crud.repos;

import org.springframework.data.repository.CrudRepository;
import springboot.crud.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);
    void deleteById(Long id);
}
