package sagengaliyev.project.online_library.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import sagengaliyev.project.online_library.models.UsersModel;
import sagengaliyev.project.online_library.repository.UsersRepository;

@Service
public class UsersService {
    private final UsersRepository usersRepo;

    public UsersService(UsersRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    public UsersModel registerUser (String login, String password){
        if(login != null && password != null){
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            return usersRepo.save(usersModel);
        } else {
            return null;
        }
    }

    public UsersModel authenticateUser(String login, String password){
        return usersRepo.findByLoginAndPassword(login,password).orElse(null);
    }
}
