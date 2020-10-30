package ro.tuc.ds2020.dtos;


import java.util.UUID;

public class UserAuthenticationDTO extends BaseDTO {

    private String username;
    private String password;
    private UserRoleDTO userRole;


    public UserAuthenticationDTO(){
    }

    public UserAuthenticationDTO(UUID id, String username, String password, UserRoleDTO userRole) {
        super(id);
        this.username = username;
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

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }
}
