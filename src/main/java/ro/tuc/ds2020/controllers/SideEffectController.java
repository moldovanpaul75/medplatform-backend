package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.SideEffectDTO;
import ro.tuc.ds2020.services.IService;

@RestController
@RequestMapping(value = "/side_effect")
public class SideEffectController extends Controller<SideEffectDTO> {

    @Autowired
    protected SideEffectController(IService<SideEffectDTO> facade) {
        super(facade);
    }
}
