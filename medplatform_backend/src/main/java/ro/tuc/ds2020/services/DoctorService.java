package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.dtos.DoctorDTO;
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
public class DoctorService extends Service<DoctorDTO, UserDetails> implements IDoctorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IDoctorService.class);

    @Autowired
    protected DoctorService(UserDetailsRepository repository, IMapper<DoctorDTO, UserDetails> mapper) {
        super(repository, mapper);
    }


    @Override
    @Transactional(readOnly = true)
    public List<DoctorDTO> findAll() {
        LOGGER.debug("{} searched for entities in table", this.getClass().getSimpleName());
        return StreamSupport.stream(((UserDetailsRepository) repository).findAllUsers("ROLE_doctor").spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<DoctorDTO> findUserByAuthId(UUID id) {
        Optional<UserDetails> entity = ((UserDetailsRepository)repository).findProfileByAuthId(id);
        if(!entity.isPresent()){
            LOGGER.error("{} could not find id {} in db", this.getClass().getSimpleName(), id);
        }
        return entity.map(mapper::toDTO);
    }
}
