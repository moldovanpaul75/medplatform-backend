package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.dtos.SideEffectDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.SideEffect;
import ro.tuc.ds2020.repositories.SideEffectRepository;

import java.util.UUID;


@Component
public class SideEffectService extends Service<SideEffectDTO, SideEffect> implements ISideEffectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ISideEffectService.class);

    @Autowired
    protected SideEffectService(SideEffectRepository repository, IMapper<SideEffectDTO, SideEffect> mapper) {
        super(repository, mapper);
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID update(SideEffectDTO dto) {
        SideEffect entity = mapper.toEntity(dto);
        entity.setMedicationList(((SideEffectRepository)repository).findById(dto.getId()).get().getMedicationList());
        repository.save(entity);
        LOGGER.debug("{} updated id {} in db", this.getClass().getSimpleName(), entity.getId());
        return entity.getId();
    }
}
