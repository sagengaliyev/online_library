package sagengaliyev.project.online_library.mapper;

import org.springframework.stereotype.Component;
import sagengaliyev.project.online_library.dto.UsersDTO;
import sagengaliyev.project.online_library.model.User;

@Component
public class UserMapper {
    public UsersDTO toDTO(User users){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUserid(users.getUserid());
        usersDTO.setFirstName(users.getFirstName());
        usersDTO.setLastName(users.getLastName());
        usersDTO.setLogin(users.getLogin());
        usersDTO.setPassword(users.getPassword());
        return usersDTO;
    }
}
