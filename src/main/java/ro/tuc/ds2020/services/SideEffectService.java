package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.SideEffectDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.SideEffect;
import ro.tuc.ds2020.repositories.SideEffectRepository;



@Component
public class SideEffectService extends Service<SideEffectDTO, SideEffect> implements ISideEffectService {
    protected SideEffectService(SideEffectRepository repository, IMapper<SideEffectDTO, SideEffect> mapper) {
        super(repository, mapper);
    }
}
