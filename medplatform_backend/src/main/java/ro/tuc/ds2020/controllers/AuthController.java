package ro.tuc.ds2020.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.payload.request.LoginRequest;
import ro.tuc.ds2020.controllers.payload.response.JwtResponse;
import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
import ro.tuc.ds2020.security.jwt.JwtUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserAuthenticationDTO userAuth = (UserAuthenticationDTO) authentication.getPrincipal();

        List<String> roles = userAuth.getAuthorities()
                                        .stream()
                                        .map(item -> item.getAuthority())
                                        .collect(Collectors.toList());

        return new ResponseEntity<>(new JwtResponse(jwt, userAuth.getId(), userAuth.getUsername(), userAuth.getEmail(), roles), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getUsername(){
        Optional<String> username = jwtUtils.getCurrentUsername();
        return new ResponseEntity<>(username.get(), HttpStatus.OK);
    }

}
