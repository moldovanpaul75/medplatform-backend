package ro.tuc.ds2020.dtos;


import java.util.UUID;

public class UserRoleDTO extends BaseDTO {

    private String name;

    public UserRoleDTO(){
        super();
    }

    public UserRoleDTO(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
