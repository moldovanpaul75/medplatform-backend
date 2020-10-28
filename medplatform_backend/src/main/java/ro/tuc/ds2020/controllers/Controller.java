package ro.tuc.ds2020.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public List<T> list() {
        return (List<T>) facade.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<T> get(@PathVariable(value = "id") UUID id) {
        return facade.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UUID create(@RequestBody T dto) {
        return facade.save(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody T dto){
        facade.update(dto);
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
