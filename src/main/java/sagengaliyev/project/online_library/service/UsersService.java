package sagengaliyev.project.online_library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sagengaliyev.project.online_library.dto.UsersDTO;
import sagengaliyev.project.online_library.mapper.UserMapper;
import sagengaliyev.project.online_library.model.User;
import sagengaliyev.project.online_library.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepo;
    private final UserMapper userMapper;


    public User registerUser (String login, String password){
        if(login != null && password != null){
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            return usersRepo.save(user);
        } else {
            return null;
        }
    }
    public User authenticateUser(String login, String password){
        return usersRepo.findByLoginAndPassword(login,password).orElse(null);
    }
    public List<UsersDTO> getAllUsers(){
        return usersRepo.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }


}
