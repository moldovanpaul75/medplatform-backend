package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.AddressDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.Address;
import ro.tuc.ds2020.repositories.AddressRepository;


@Component
public class AddressService extends Service<AddressDTO, Address> implements IAddressService{

    @Autowired
    protected AddressService(AddressRepository repository, IMapper<AddressDTO, Address> mapper) {
        super(repository, mapper);
    }
}
