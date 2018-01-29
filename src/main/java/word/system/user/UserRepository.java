package word.system.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Long> {

    User getByLogin(String login);

    Collection<User> getByRole(User.Role role);

    User getByRoleAndLogin(User.Role role, String login);
}
