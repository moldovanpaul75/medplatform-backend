package ro.tuc.ds2020.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_details")
public class UserDetails extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "patient_caregiver",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "caregiver_id")
    )
    private UserDetails caregiver;

    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<UserDetails> patients;

    @OneToMany(mappedBy = "patient", cascade =  CascadeType.ALL)
    private List<MedicalRecord> medicalRecord;

    @OneToMany(mappedBy = "doctor", cascade =  CascadeType.ALL)
    private List<MedicationPlan> doctorMedicalPlans;

    @OneToMany(mappedBy = "patient", cascade =  CascadeType.ALL)
    private List<MedicationPlan> patientMedicalPlans;

    public UserDetails(){
    }

    public UserDetails(String firstName, String lastName, String email, Date dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
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

    public UserDetails getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(UserDetails caregiver) {
        this.caregiver = caregiver;
    }

    public List<UserDetails> getPatients() {
        return patients;
    }

    public void setPatients(List<UserDetails> patients) {
        this.patients = patients;
    }

    public List<MedicalRecord> getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(List<MedicalRecord> medicalRecord) {
        this.medicalRecord = medicalRecord;
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
}
