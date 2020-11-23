package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "medical_record")
public class MedicalRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "release_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "details", nullable = false)
    private String details;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "patient", referencedColumnName = "id", nullable = false)
    private UserDetails patient;

    public MedicalRecord(){
    }

    public MedicalRecord(Date date, String details) {
        this.releaseDate = date;
        this.details = details;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public UserDetails getPatient() {
        return patient;
    }

    public void setPatient(UserDetails patient) {
        this.patient = patient;
    }
}
