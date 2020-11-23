package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_details")
public class UserDetails extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    ///
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    ///
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_authentication", referencedColumnName = "id")
    private UserAuthentication userAuthentication;

    ///
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecord;
    //
    @OneToMany(mappedBy = "doctor")
    private List<MedicationPlan> doctorMedicalPlans;
    //
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicationPlan> patientMedicalPlans;
    //
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "patient_caregiver",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "caregiver_id")
    )
    private List<UserDetails> caregivers;
    //
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
                name = "patient_caregiver",
                joinColumns = @JoinColumn(name = "caregiver_id"),
                inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private List<UserDetails> patients;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<Activity> activities;


    public UserDetails(){
    }

    public UserDetails(String firstName, String lastName, Date dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public UserDetails(String firstName, String lastName, Date dateOfBirth, String gender, Address address, UserAuthentication userAuthentication) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.userAuthentication = userAuthentication;
    }

    public UserDetails(String firstName, String lastName, Date dateOfBirth, String gender, Address address, UserAuthentication userAuthentication, List<UserDetails> caregivers, List<MedicalRecord> medicalRecord, List<MedicationPlan> doctorMedicalPlans) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.userAuthentication = userAuthentication;
        this.caregivers = caregivers;
        this.medicalRecord = medicalRecord;
        this.doctorMedicalPlans = doctorMedicalPlans;
    }

    public UserDetails(String firstName, String lastName, Date dateOfBirth, String gender, Address address, UserAuthentication userAuthentication, List<UserDetails> patients) {
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

    public List<UserDetails> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(List<UserDetails> caregivers) {
        this.caregivers = caregivers;
    }

    public List<UserDetails> getPatients() {
        return patients;
    }

    public void setPatients(List<UserDetails> patients) {
        this.patients = patients;
    }

    public List<MedicationPlan> getDoctorMedicalPlans() {
        return doctorMedicalPlans;
    }

    public void setDoctorMedicalPlans(List<MedicationPlan> doctorMedicalPlans) {
        this.doctorMedicalPlans = doctorMedicalPlans;
    }

    public List<MedicationPlan> getPatientMedicalPlans() {
        return patientMedicalPlans;
    }

    public void setPatientMedicalPlans(List<MedicationPlan> patientMedicalPlans) {
        this.patientMedicalPlans = patientMedicalPlans;
    }

    public List<MedicalRecord> getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(List<MedicalRecord> medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public void addPatientToCaregiver(UserDetails patient){
        this.patients.add(patient);
    }


}
