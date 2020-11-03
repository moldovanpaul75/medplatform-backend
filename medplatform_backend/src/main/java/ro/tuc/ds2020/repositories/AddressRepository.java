package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Address;

import java.util.UUID;

@Repository
public interface AddressRepository extends IBaseRepository<Address, UUID> {
}
