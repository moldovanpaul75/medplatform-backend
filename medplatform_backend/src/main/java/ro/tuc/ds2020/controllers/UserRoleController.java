package ro.tuc.ds2020.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.UserRoleDTO;
import ro.tuc.ds2020.services.IService;

@RestController
@RequestMapping(value = "/user_role")
public class UserRoleController extends Controller<UserRoleDTO> {

    protected UserRoleController(IService<UserRoleDTO> facade) {
        super(facade);
    }
}
