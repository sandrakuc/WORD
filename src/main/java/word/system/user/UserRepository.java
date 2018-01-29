package word.system.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User getByLogin(String login);

    Collection<User> getByRole(User.Role role);

    User getByRoleAndLogin(User.Role role, String login);
    List<User> findByLastNameStartsWithIgnoreCase(String lastName);
}
