package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "medication_plan")
public class MedicationPlan extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "dosage", nullable = false)
    private String dosage;

    @Column(name = "medication_plan_start", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date start;

    @Column(name = "medication_plan_end", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date end;

    @Column(name = "morning", nullable = false)
    private boolean morning;

    @Column(name = "afternoon", nullable = false)
    private boolean afternoon;

    @Column(name = "evening", nullable = false)
    private boolean evening;

    @ManyToOne
    @JoinColumn(name = "patient", referencedColumnName = "id", nullable = false)
    private UserDetails patient;

    @ManyToOne
    @JoinColumn(name = "doctor", referencedColumnName = "id", nullable = false)
    private UserDetails doctor;

    @ManyToOne
    @JoinColumn(name = "medication", referencedColumnName = "id")
    private Medication medication;

    public MedicationPlan(){
    }

    public MedicationPlan(String dosage, Date start, Date end, boolean morning, boolean afternoon, boolean evening, UserDetails patient, UserDetails doctor, Medication medication) {
        this.dosage = dosage;
        this.start = start;
        this.end = end;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
        this.patient = patient;
        this.doctor = doctor;
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public boolean isEvening() {
        return evening;
    }

    public void setEvening(boolean evening) {
        this.evening = evening;
    }

    public UserDetails getPatient() {
        return patient;
    }

    public void setPatient(UserDetails patient) {
        this.patient = patient;
    }

    public UserDetails getDoctor() {
        return doctor;
    }

    public void setDoctor(UserDetails doctor) {
        this.doctor = doctor;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
