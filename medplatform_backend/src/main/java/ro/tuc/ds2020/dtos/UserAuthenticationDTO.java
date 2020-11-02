package ro.tuc.ds2020.dtos;


import java.util.UUID;

public class UserAuthenticationDTO extends BaseDTO {

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
}
