package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_authentication", referencedColumnName = "id")
    private UserAuthentication userAuthentication;


    public UserDetails(){
    }

    public UserDetails(String firstName, String lastName, String email, Date dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserAuthentication getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserAuthentication(UserAuthentication userAuthentication) {
        this.userAuthentication = userAuthentication;
    }
}
