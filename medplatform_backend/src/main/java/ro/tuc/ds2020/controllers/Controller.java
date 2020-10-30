package ro.tuc.ds2020.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.BaseDTO;
import ro.tuc.ds2020.services.IService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public abstract class Controller<T extends BaseDTO> {

    protected final IService<T> facade;

    protected Controller(IService<T> facade) {
        this.facade = facade;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<T>> list() {
        List<T> dtos = (List<T>) facade.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> get(@PathVariable(value = "id") UUID id) {
        Optional<T> dto = facade.findById(id);
        return new ResponseEntity<>(dto.get(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UUID> create(@RequestBody T dto) {
        UUID id = facade.save(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(value = "bulk", method = RequestMethod.POST)
    public ResponseEntity<List<T>> insertList(@RequestBody List<T> dtos){
        facade.saveBulk(dtos);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UUID> update(@RequestBody T dto){
        UUID id = facade.update(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void updateById(@PathVariable("id") UUID id, @RequestBody T dto){
        facade.updateById(dto, id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody T dto){
        facade.delete(dto);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(value = "id") UUID id){
        facade.deleteById(id);
    }

}
