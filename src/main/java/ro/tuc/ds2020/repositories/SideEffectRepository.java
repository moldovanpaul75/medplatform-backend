package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.SideEffect;

import java.util.UUID;

@Repository
public interface SideEffectRepository extends IBaseRepository<SideEffect, UUID>{
}
