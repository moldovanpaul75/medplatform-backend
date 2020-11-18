package ro.tuc.ds2020.dtos;


import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CaregiverDTO extends BaseDTO {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;

    private AddressDTO address;
    private UserAuthenticationDTO userAuthentication;
    private List<PatientDTO> patients;

    public CaregiverDTO() {
        super();
    }

    public CaregiverDTO(UUID id, String firstName, String lastName, Date dateOfBirth, String gender) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public CaregiverDTO(UUID id, String firstName, String lastName, Date dateOfBirth, String gender, AddressDTO address, UserAuthenticationDTO userAuthentication, List<PatientDTO> patients) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.userAuthentication = userAuthentication;
        this.patients = patients;
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

    public List<PatientDTO> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDTO> patients) {
        this.patients = patients;
    }

    public void addPatient(PatientDTO patient){
        this.patients.add(patient);
    }

    public void removePatient(PatientDTO patient){
        this.patients.remove(patient);
    }
}
