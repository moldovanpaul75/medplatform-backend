package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.UserRoleDTO;
import ro.tuc.ds2020.services.IService;

import java.util.List;

@RestController
@RequestMapping(value = "/user_role")
public class UserRoleController extends Controller<UserRoleDTO> {

    @Autowired
    protected UserRoleController(IService<UserRoleDTO> facade) {
        super(facade);
    }

}
