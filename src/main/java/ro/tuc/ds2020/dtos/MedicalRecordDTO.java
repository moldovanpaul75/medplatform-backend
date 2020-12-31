package ro.tuc.ds2020.dtos;


import java.util.Date;
import java.util.UUID;

public class MedicalRecordDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    private Date releaseDate;
    private String details;

    private PatientDTO patient;

    public MedicalRecordDTO() {
        super();
    }

    public MedicalRecordDTO(UUID id, Date releaseDate, String details) {
        super(id);
        this.releaseDate = releaseDate;
        this.details = details;
    }

    public MedicalRecordDTO(UUID id, Date releaseDate, String details, PatientDTO patient) {
        super(id);
        this.releaseDate = releaseDate;
        this.details = details;
        this.patient = patient;
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

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
