package sagengaliyev.project.online_library.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class UsersDTO {
    @Id
    private long userid;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;

}
