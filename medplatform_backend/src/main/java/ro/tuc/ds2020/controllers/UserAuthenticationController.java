package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
import ro.tuc.ds2020.services.IService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/user_authentication")
public class UserAuthenticationController extends Controller<UserAuthenticationDTO> {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    protected UserAuthenticationController(IService<UserAuthenticationDTO> facade) {
        super(facade);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UUID> create(@RequestBody UserAuthenticationDTO dto) {
        String encodedPass = encoder.encode(dto.getPassword());
        dto.setPassword(encodedPass);
        UUID id = facade.save(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

}
