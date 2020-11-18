package ro.tuc.ds2020.dtos;


import java.util.UUID;

public class AddressDTO extends BaseDTO{

    private String street;
    private String city;
    private String state;
    private String zipCode;

    public AddressDTO(){
        super();
    }

    public AddressDTO(UUID id, String street, String city, String state, String zipCode) {
        super(id);
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
