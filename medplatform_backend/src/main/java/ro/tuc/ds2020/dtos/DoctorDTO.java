package ro.tuc.ds2020.dtos;


import java.util.Date;
import java.util.UUID;

public class DoctorDTO extends BaseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;

    private AddressDTO address;
    private UserAuthenticationDTO userAuthentication;

    public DoctorDTO() {
        super();
    }

    public DoctorDTO(UUID id, String firstName, String lastName, String email, Date dateOfBirth, String gender) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public DoctorDTO(UUID id, String firstName, String lastName, String email, Date dateOfBirth, String gender, AddressDTO address, UserAuthenticationDTO userAuthentication) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.userAuthentication = userAuthentication;
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public UserAuthenticationDTO getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserAuthentication(UserAuthenticationDTO userAuthentication) {
        this.userAuthentication = userAuthentication;
    }
}
