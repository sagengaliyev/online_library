package sagengaliyev.project.online_library.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import sagengaliyev.project.online_library.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserDetails  implements org.springframework.security.core.userdetails.UserDetails {

    private String login;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserDetails(User user) {
        this.login = user.getLogin();
        this.password=user.getPassword();

    }

    public UserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return "pass";
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
