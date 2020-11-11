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
    private List<MedicationPlanDTO> patientMedicalPlans;
    private List<MedicalRecordDTO> medicalRecord;

    public PatientDTO() {
        super();
    }

    public PatientDTO(UUID id, String firstName, String lastName, Date dateOfBirth, String gender) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public PatientDTO(UUID id, String firstName, String lastName, Date dateOfBirth, String gender, AddressDTO address, UserAuthenticationDTO userAuthentication, CaregiverDTO caregiver, List<MedicationPlanDTO> patientMedicalPlans, List<MedicalRecordDTO> medicalRecord) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.userAuthentication = userAuthentication;
        this.caregiver = caregiver;
        this.patientMedicalPlans = patientMedicalPlans;
        this.medicalRecord = medicalRecord;
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

    public List<MedicalRecordDTO> getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(List<MedicalRecordDTO> medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public List<MedicationPlanDTO> getPatientMedicalPlans() {
        return patientMedicalPlans;
    }

    public void setPatientMedicalPlans(List<MedicationPlanDTO> patientMedicalPlans) {
        this.patientMedicalPlans = patientMedicalPlans;
    }
}
