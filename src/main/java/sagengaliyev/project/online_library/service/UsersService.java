package sagengaliyev.project.online_library.service;

import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sagengaliyev.project.online_library.dto.UsersDTO;
import sagengaliyev.project.online_library.mapper.UserMapper;
import sagengaliyev.project.online_library.model.User;
import sagengaliyev.project.online_library.repository.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class UsersService  {


    private UsersRepository userRepo;
    private UserMapper userMapper;

    public UsersService(UsersRepository userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }


    public Optional<User> findUserById(long id) {
        return userRepo.findById(id);
    }

    public User deleteUser(long id) {

        Optional<User> retrievedUser=userRepo.findById(id);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepo.deleteById(id);
        return retrievedUser.get();



    }


    public List<UsersDTO> getAllUsers(){
        return userRepo.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new sagengaliyev.project.online_library.service.UserDetails(user);
//    }


}
