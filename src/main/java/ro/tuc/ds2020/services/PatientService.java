package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserAuthentication;
import ro.tuc.ds2020.entities.UserDetails;
import ro.tuc.ds2020.repositories.UserAuthenticationRepository;
import ro.tuc.ds2020.repositories.UserDetailsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class PatientService extends Service<PatientDTO, UserDetails> implements IPatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPatientService.class);


    protected final PasswordEncoder encoder;

    protected final UserAuthenticationRepository userAuthenticationRepository;


    @Autowired
    protected PatientService(UserDetailsRepository repository, IMapper<PatientDTO, UserDetails> mapper, PasswordEncoder encoder, UserAuthenticationRepository userAuthenticationRepository) {
        super(repository, mapper);
        this.encoder = encoder;
        this.userAuthenticationRepository = userAuthenticationRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID save(PatientDTO dto) {
        Optional<UserAuthentication> userAuthentication = Optional.empty();

        if(dto.getUserAuthentication().getId() != null){
            userAuthentication = userAuthenticationRepository.findById(dto.getUserAuthentication().getId());
        }

        UserDetails entity = mapper.toEntity(dto);
        if(userAuthentication.isPresent()){
            entity.setUserAuthentication(userAuthentication.get());
        } else {
            entity.getUserAuthentication().setPassword(encoder.encode(dto.getUserAuthentication().getPassword()));
        }

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID update(PatientDTO dto) {
        UserDetails entity = mapper.toEntity(dto);
        entity.setCaregivers(((UserDetailsRepository)repository).findById(dto.getId()).get().getCaregivers());
        repository.save(entity);
        LOGGER.debug("{} updated id {} in db", this.getClass().getSimpleName(), entity.getId());
        return entity.getId();
    }

}
