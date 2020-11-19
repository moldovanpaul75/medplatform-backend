package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.UserRole;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends IBaseRepository<UserRole, UUID>{

    Optional<UserRole> findByName(String name);

}
