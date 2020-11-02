package ro.tuc.ds2020.dtos;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class UserAuthenticationDTO extends BaseDTO implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String email;
    private UserRoleDTO userRole;


    public UserAuthenticationDTO(){
    }

    public UserAuthenticationDTO(String username, String email, UserRoleDTO userRole) {
        this.username = username;
        this.email = email;
        this.userRole = userRole;
    }

    public UserAuthenticationDTO(UUID id, String username, String password, String email, UserRoleDTO userRole) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.userRole.getName()));

        return authorities;
    }
}
