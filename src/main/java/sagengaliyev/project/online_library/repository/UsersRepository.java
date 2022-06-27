package sagengaliyev.project.online_library.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import sagengaliyev.project.online_library.models.UsersModel;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    Optional <UsersModel> findByLoginAndPassword(String login, String password);
}
