package sagengaliyev.project.online_library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sagengaliyev.project.online_library.dto.UsersDTO;
import sagengaliyev.project.online_library.model.User;
import sagengaliyev.project.online_library.service.BookingService;
import sagengaliyev.project.online_library.service.UsersService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/library/auth")
public class UsersController {

//    private List<User> users = Stream.of(
//            new User("Adil", "Sagengaliyev", "adil", "adil2022")
//    ).collect(Collectors.toList());
    private final UsersService usersService;

    public UsersController(UsersService usersService) {

        this.usersService = usersService;
    }

//    @GetMapping
//    public List<User> getAll(){
//        return users;
//    }
//    @GetMapping("/{id}")
//    public User getById(@PathVariable Long id){
//        return users.stream().filter(user -> user.getId().equals(id))
//                .findFirst().orElse(null);
//    }
//
//    @PostMapping
//    public User create(@RequestBody User user){
//        this.users.add(user);
//        return user;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Long id){
//        this.users.removeIf(user -> user.getId().equals(id));
//    }

    @GetMapping("/login")
    public String welcomeUser(){
        return "Welcome user!";
    }


}


