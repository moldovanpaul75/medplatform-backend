package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.dtos.CaregiverDTO;
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
    private PasswordEncoder encoder;

    @Autowired
    protected CaregiverService(UserDetailsRepository repository, IMapper<CaregiverDTO, UserDetails> mapper) {
        super(repository, mapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID save(CaregiverDTO dto) {
        UserDetails entity = mapper.toEntity(dto);
        entity.getUserAuthentication().setPassword(encoder.encode(dto.getUserAuthentication().getPassword()));
        UserDetails e = repository.save(entity);
        LOGGER.debug("{} with id {} was inserted in db", entity.getClass().getSimpleName(), entity.getId());
        return e.getId();
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

    @Transactional(readOnly = true)
    public Optional<CaregiverDTO> findUserByAuthId(UUID id) {
        Optional<UserDetails> entity = ((UserDetailsRepository)repository).findProfileByAuthId(id);
        if(!entity.isPresent()){
            LOGGER.error("{} could not find id {} in db", this.getClass().getSimpleName(), id);
        }
        return entity.map(mapper::toDTO);
    }


    @Transactional(rollbackFor = Exception.class)
    public UUID updatePatients(CaregiverDTO dto) {

        List<UUID> ids = dto.getPatients().stream().map( entity -> entity.getId()).collect(Collectors.toList());
        Optional<UserDetails> entity = repository.findById(dto.getId());
        entity.get().getPatients().clear();

        ids.forEach(id ->{
            Optional<UserDetails> patient = repository.findById(id);
            entity.get().addPatientToCaregiver(patient.get());
        });

        UserDetails e = repository.save(entity.get());
        LOGGER.debug("{} with id {} was inserted in db", entity.getClass().getSimpleName(), entity.get().getId());
        return e.getId();
    }
}
