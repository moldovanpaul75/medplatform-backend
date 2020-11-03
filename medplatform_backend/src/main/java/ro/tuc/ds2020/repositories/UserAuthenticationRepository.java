package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.UserAuthentication;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAuthenticationRepository extends IBaseRepository<UserAuthentication, UUID>{

    Optional<UserAuthentication> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
