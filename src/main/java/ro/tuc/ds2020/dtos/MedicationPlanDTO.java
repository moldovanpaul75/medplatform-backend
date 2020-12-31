package ro.tuc.ds2020.dtos;


import java.util.Date;
import java.util.UUID;

public class MedicationPlanDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    private String dosage;
    private Date start;
    private Date end;
    private boolean morning;
    private boolean afternoon;
    private boolean evening;

    private PatientDTO patient;
    private DoctorDTO doctor;
    private MedicationDTO medication;

    public MedicationPlanDTO() {
        super();
    }

    public MedicationPlanDTO(UUID id, String dosage, Date start, Date end, boolean morning, boolean afternoon, boolean evening) {
        super(id);
        this.dosage = dosage;
        this.start = start;
        this.end = end;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
    }

    public MedicationPlanDTO(UUID id, String dosage, Date start, Date end, boolean morning, boolean afternoon, boolean evening, PatientDTO patient, DoctorDTO doctor, MedicationDTO medication) {
        super(id);
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

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public MedicationDTO getMedication() {
        return medication;
    }

    public void setMedication(MedicationDTO medication) {
        this.medication = medication;
    }
}
