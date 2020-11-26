package ro.tuc.ds2020.dtos;

import java.util.UUID;

public class ActivityDTO extends BaseDTO{

    private long start;
    private long end;
    private String activity;
    private UUID patient_id;
    private boolean flag = false;

    public ActivityDTO(){ super(); }

    public ActivityDTO(UUID id, long start, long end, String activity, UUID patient_id) {
        super(id);
        this.start = start;
        this.end = end;
        this.activity = activity;
        this.patient_id = patient_id;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public UUID getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(UUID patient_id) {
        this.patient_id = patient_id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "start=" + start +
                ", end=" + end +
                ", activity='" + activity + '\'' +
                ", patient_id=" + patient_id +
                ", flag=" + flag +
                '}';
    }
}
