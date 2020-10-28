package ro.tuc.ds2020.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "userRole")
    private UserAuthentication user;

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
