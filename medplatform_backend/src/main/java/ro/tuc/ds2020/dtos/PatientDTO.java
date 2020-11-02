package ro.tuc.ds2020.dtos;


import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PatientDTO extends BaseDTO {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;

    private AddressDTO address;
    private UserAuthenticationDTO userAuthentication;
    private CaregiverDTO caregiver;
    private List<MedicationPlanDTO> medicationPlans;
    private List<MedicalRecordDTO> medicationRecord;

    public PatientDTO() {
    }

    public PatientDTO(UUID id, String firstName, String lastName, Date dateOfBirth, String gender) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public PatientDTO(UUID id, String firstName, String lastName, String email, Date dateOfBirth, String gender, AddressDTO address, UserAuthenticationDTO userAuthentication, CaregiverDTO caregiver, List<MedicationPlanDTO> medicationPlans, List<MedicalRecordDTO> medicationRecord) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.userAuthentication = userAuthentication;
        this.caregiver = caregiver;
        this.medicationPlans = medicationPlans;
        this.medicationRecord = medicationRecord;
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

    public CaregiverDTO getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(CaregiverDTO caregiver) {
        this.caregiver = caregiver;
    }

    public List<MedicationPlanDTO> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlanDTO> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }

    public List<MedicalRecordDTO> getMedicationRecord() {
        return medicationRecord;
    }

    public void setMedicationRecord(List<MedicalRecordDTO> medicationRecord) {
        this.medicationRecord = medicationRecord;
    }
}
