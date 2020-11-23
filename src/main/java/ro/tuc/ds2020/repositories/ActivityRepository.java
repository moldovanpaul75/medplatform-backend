package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Activity;


import java.util.UUID;

@Repository
public interface ActivityRepository extends IBaseRepository<Activity, UUID>{
}
