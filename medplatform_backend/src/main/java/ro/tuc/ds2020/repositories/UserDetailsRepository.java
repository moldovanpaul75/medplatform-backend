package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.UserDetails;

import java.util.UUID;

@Repository
public interface UserDetailsRepository extends IBaseRepository<UserDetails, UUID>{

}
