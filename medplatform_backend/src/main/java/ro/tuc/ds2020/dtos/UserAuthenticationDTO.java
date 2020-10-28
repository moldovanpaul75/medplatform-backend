package ro.tuc.ds2020.dtos;


import java.util.UUID;

public class UserAuthenticationDTO extends BaseDTO {

    private String username;
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

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }
}
