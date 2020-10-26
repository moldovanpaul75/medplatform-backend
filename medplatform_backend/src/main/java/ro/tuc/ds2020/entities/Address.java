package ro.tuc.ds2020.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private UserDetails userDetails;

    public Address(){
    }

    public Address(String street, String city, String state, String zipCode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet(){
        return this.street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getZipCode(){
        return this.zipCode;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
}
