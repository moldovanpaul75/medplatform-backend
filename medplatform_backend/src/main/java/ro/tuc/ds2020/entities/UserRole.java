package ro.tuc.ds2020.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<UserAuthentication> users;

    public UserRole(){
    }

    public UserRole(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
