package ro.tuc.ds2020.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user_authentication")
public class UserAuthentication extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    private UserRole userRole;

    @OneToOne(mappedBy = "userAuthentication")
    private UserDetails userDetails;

    public UserAuthentication(){
    }

    public UserAuthentication(String username, String password, String email, UserRole userRole) {
        this.username = username;
        this.password = password;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
