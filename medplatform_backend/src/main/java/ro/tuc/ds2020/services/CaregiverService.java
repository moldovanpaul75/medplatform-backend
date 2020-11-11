package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserDetails;
import ro.tuc.ds2020.repositories.UserDetailsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class CaregiverService extends Service<CaregiverDTO, UserDetails> implements ICaregiverService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ICaregiverService.class);

    @Autowired
    protected CaregiverService(UserDetailsRepository repository, IMapper<CaregiverDTO, UserDetails> mapper) {
        super(repository, mapper);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CaregiverDTO> findById(UUID id) {
        Optional<UserDetails> entity = repository.findById(id);
        if(!entity.isPresent()){
            LOGGER.error("{} could not find id {} in db", this.getClass().getSimpleName(), id);
        }
        CaregiverDTO dto = mapper.toDTO(entity.get());
        return Optional.ofNullable(dto);
    }


    @Override
    @Transactional(readOnly = true)
    public List<CaregiverDTO> findAll() {
        LOGGER.debug("{} searched for entities in table", this.getClass().getSimpleName());
        return StreamSupport.stream(((UserDetailsRepository) repository).findAllUsers("ROLE_caregiver").spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
