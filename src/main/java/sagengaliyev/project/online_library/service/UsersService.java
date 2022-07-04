package sagengaliyev.project.online_library.service;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sagengaliyev.project.online_library.dto.UsersDTO;
import sagengaliyev.project.online_library.models.UsersModel;
import sagengaliyev.project.online_library.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {
    private final UsersRepository usersRepo;
    private final ModelMapper modelMapper;
    public UsersService(UsersRepository usersRepo, ModelMapper modelMapper) {
        this.usersRepo = usersRepo;
        this.modelMapper = modelMapper;
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
    public List<UsersDTO> getAllUsers(){
        return usersRepo.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private UsersDTO convertEntityToDTO(UsersModel users){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUserid(users.getUserid());
        usersDTO.setFirstName(users.getFirstName());
        usersDTO.setLastName(users.getLastName());
        usersDTO.setLogin(users.getLogin());
        usersDTO.setPassword(users.getPassword());
        return usersDTO;
    }
}
