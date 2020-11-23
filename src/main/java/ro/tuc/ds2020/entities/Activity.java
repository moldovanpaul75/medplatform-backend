package ro.tuc.ds2020.entities;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "activity")
public class Activity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "activity_start", nullable = false)
    private String activityStart;

    @Column(name = "activity_end", nullable = false)
    private String activityEnd;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "flag", nullable = false)
    private boolean flag;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "patient", referencedColumnName = "id", nullable = false)
    private UserDetails userDetails;

    public Activity(){
    }

    public String getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(String activityStart) {
        this.activityStart = activityStart;
    }

    public String getActivityEnd() {
        return activityEnd;
    }

    public void setActivityEnd(String activityEnd) {
        this.activityEnd = activityEnd;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityStart='" + activityStart + '\'' +
                ", activityEnd='" + activityEnd + '\'' +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                ", userDetails=" + userDetails.getId() +
                '}';
    }
}
