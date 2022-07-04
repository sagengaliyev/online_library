package sagengaliyev.project.online_library.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sagengaliyev.project.online_library.dto.UsersDTO;
import sagengaliyev.project.online_library.models.UsersModel;
import sagengaliyev.project.online_library.repository.UsersRepository;
import sagengaliyev.project.online_library.service.UsersService;

import java.util.List;

@Controller
public class UsersController {


    private final UsersService usersService;

    public UsersController(UsersService usersService) {

        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UsersModel());
        return "register-page";
    }
//    @PostMapping("/register")
//    public String registerNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String login, @RequestParam String password){
//        UsersModel usersModel = new UsersModel(firstName, lastName, login, password);
//        usersService().save(usersModel);
//        System.out.println("You have been successfully registered!");
//        return "redirect:/login";
//    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login-page";
    }

//    @PostMapping("/login")
//        public String loginUser(@ModelAttribute User usersModel) {
//        UsersModel authUser = usersService.authenticateUser(usersModel.getLogin(), usersModel.getPassword());
//        if(authUser!=null){
//          return "error_page";
//        } else {
//           return "redirect:/login";
//        }
//   }

    @GetMapping("/allusers")
    public List<UsersDTO> getAllUsers(){
        return usersService.getAllUsers();
    }

}


