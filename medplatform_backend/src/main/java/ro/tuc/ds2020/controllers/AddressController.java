package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.AddressDTO;
import ro.tuc.ds2020.services.IAddressService;


@RestController
@RequestMapping(value = "/address")
public class AddressController extends Controller<AddressDTO>{


    @Autowired
    public AddressController(IAddressService facade) {
        super(facade);
    }

}
