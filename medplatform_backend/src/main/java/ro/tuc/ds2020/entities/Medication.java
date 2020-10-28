package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "medication")
public class Medication extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "medication_side_effects",
            joinColumns = @JoinColumn(name = "medication_id"),
            inverseJoinColumns = @JoinColumn(name = "side_effect_id")
    )
    private List<SideEffect> sideEffectList;

    @OneToMany(mappedBy = "medication", cascade =  CascadeType.ALL)
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
