package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.UserRoleDTO;
import ro.tuc.ds2020.services.IService;
import ro.tuc.ds2020.services.UserRoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user_role")
public class UserRoleController extends Controller<UserRoleDTO> {

    @Autowired
    protected UserRoleController(IService<UserRoleDTO> facade) {
        super(facade);
    }


    @RequestMapping(value = "/name={name}", method = RequestMethod.GET)
    public ResponseEntity<UserRoleDTO> getRoleByName(@PathVariable(value = "name") String name){

        Optional<UserRoleDTO> dto = ((UserRoleService)facade).findByName(name);

        if(!dto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dto.get(), HttpStatus.OK);
    }

}
