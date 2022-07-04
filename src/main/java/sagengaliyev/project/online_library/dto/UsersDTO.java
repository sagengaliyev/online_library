package sagengaliyev.project.online_library.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UsersDTO {
    private long userid;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

}
