package sagengaliyev.project.online_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sagengaliyev.project.online_library.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional <User> findByLoginAndPassword(String login, String password);


}
