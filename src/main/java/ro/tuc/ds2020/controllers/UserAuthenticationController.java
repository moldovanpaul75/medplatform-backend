package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
import ro.tuc.ds2020.services.IService;
import ro.tuc.ds2020.services.UserAuthenticationService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user_authentication")
public class UserAuthenticationController extends Controller<UserAuthenticationDTO> {

    @Autowired
    protected UserAuthenticationController(IService<UserAuthenticationDTO> facade) {
        super(facade);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UUID> create(@RequestBody UserAuthenticationDTO dto) {
        UUID id = facade.save(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
