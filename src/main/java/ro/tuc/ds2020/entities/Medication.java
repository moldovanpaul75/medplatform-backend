package ro.tuc.ds2020.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medication")
public class Medication extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "medication_side_effects",
            joinColumns = @JoinColumn(name = "medication_id"),
            inverseJoinColumns = @JoinColumn(name = "side_effect_id")
    )
    private List<SideEffect> sideEffectList;

    @OneToMany(mappedBy = "medication", cascade = {CascadeType.REFRESH})
    private List<MedicationPlan> medicationPlanList;

    public Medication(){
    }

    public Medication(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SideEffect> getSideEffectList() {
        return sideEffectList;
    }

    public void setSideEffectList(List<SideEffect> sideEffectList) {
        this.sideEffectList = sideEffectList;
    }
}