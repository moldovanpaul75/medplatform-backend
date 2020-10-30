package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
import ro.tuc.ds2020.services.IService;

@RestController
@RequestMapping(value = "/authentication")
public class UserAuthenticationController extends Controller<UserAuthenticationDTO> {

    @Autowired
    protected UserAuthenticationController(IService<UserAuthenticationDTO> facade) {
        super(facade);
    }
}
