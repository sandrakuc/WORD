package word.system.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User getByLogin(String login);
    List<User> findByLastNameStartsWithIgnoreCase(String lastName);
}
