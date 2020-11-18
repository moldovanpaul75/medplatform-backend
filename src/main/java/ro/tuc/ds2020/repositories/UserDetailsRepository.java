package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDetailsRepository extends IBaseRepository<UserDetails, UUID>{

    @Query("SELECT u FROM UserDetails u WHERE u.userAuthentication.userRole.name =:role")
    List<UserDetails> findAllUsers(@Param("role") String role);

    @Query("SELECT u FROM UserDetails u WHERE u.userAuthentication.id =:id")
    Optional<UserDetails> findProfileByAuthId(@Param("id") UUID id);
}
