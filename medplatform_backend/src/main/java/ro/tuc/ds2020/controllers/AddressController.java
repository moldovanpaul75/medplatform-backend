package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.AddressDTO;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/address")
public class AddressController {

    //private final AddressService addressService;

    //@Autowired
    //public AddressController(AddressService addressService) {
    //    this.addressService = addressService;
    //}

}
