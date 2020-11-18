package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.dtos.builders.PatientMapper;
import ro.tuc.ds2020.entities.UserDetails;
import ro.tuc.ds2020.repositories.UserDetailsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class PatientService extends Service<PatientDTO, UserDetails> implements IPatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPatientService.class);

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    protected PatientService(UserDetailsRepository repository, IMapper<PatientDTO, UserDetails> mapper) {
        super(repository, mapper);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID save(PatientDTO dto) {
        UserDetails entity = mapper.toEntity(dto);
        entity.getUserAuthentication().setPassword(encoder.encode(dto.getUserAuthentication().getPassword()));
        UserDetails e = repository.save(entity);
        LOGGER.debug("{} with id {} was inserted in db", entity.getClass().getSimpleName(), entity.getId());
        return e.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PatientDTO> findById(UUID id) {
        Optional<UserDetails> entity = repository.findById(id);
        if(!entity.isPresent()){
            LOGGER.error("{} could not find id {} in db", this.getClass().getSimpleName(), id);
        }
        return entity.map(mapper::toDTO);
    }


    @Transactional(readOnly = true)
    public Optional<PatientDTO> findUserByAuthId(UUID id) {
        Optional<UserDetails> entity = ((UserDetailsRepository)repository).findProfileByAuthId(id);
        if(!entity.isPresent()){
            LOGGER.error("{} could not find id {} in db", this.getClass().getSimpleName(), id);
        }
        return entity.map(mapper::toDTO);
    }


    @Override
    @Transactional(readOnly = true)
    public List<PatientDTO> findAll() {
        LOGGER.debug("{} searched for entities in table", this.getClass().getSimpleName());
        return StreamSupport.stream(((UserDetailsRepository) repository).findAllUsers("ROLE_patient").spliterator(), false)
                    .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}
