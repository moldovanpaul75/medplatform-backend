package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.BaseDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.BaseEntity;
import ro.tuc.ds2020.repositories.IBaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class Service<DTO extends BaseDTO, Entity extends BaseEntity> implements IService<DTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IService.class);

    protected final IBaseRepository<Entity, UUID> repository;
    protected final IMapper<DTO, Entity> mapper;


    protected Service(IBaseRepository<Entity, UUID> repository, IMapper<DTO, Entity> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID save(DTO dto) {
        Entity entity = mapper.toEntity(dto);
        if(dto.getId() == null){
            entity.setId(UUID.randomUUID());
        }
        repository.save(entity);
        LOGGER.debug("{} with id {} was inserted in db", entity.getClass().getSimpleName(), entity.getId());
        return entity.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> findAll() {
        LOGGER.debug("{} searched for values entities in table", this.getClass().getSimpleName());
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DTO> findById(UUID id) {
        Optional<Entity> entity = repository.findById(id);

        return entity.map(mapper::toDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID update(DTO dto) {
        Entity entity = mapper.toEntity(dto);
        repository.save(entity);
        LOGGER.debug("{} updated id {} in db", this.getClass().getSimpleName(), entity.getId());
        return entity.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(DTO dto, UUID id) {
        Optional<Entity> entity = repository.findById(id);
        if(!entity.isPresent()){
            LOGGER.error("{} could not find id {} in db", this.getClass().getSimpleName(), id);
            throw new ResourceNotFoundException(this.getClass().getSimpleName() + "could not find id: " + id);
        }
        repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(DTO dto) {
        Entity entity = mapper.toEntity(dto);
        LOGGER.debug("{} with id {} was deleted from db", entity.getClass().getSimpleName(), entity.getId());
        repository.delete(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(UUID id) {
        Optional<Entity> entity = repository.findById(id);
        if(!entity.isPresent()){
            LOGGER.error("{} could not find and delete id {} in db", this.getClass().getSimpleName(), id);
            throw new ResourceNotFoundException(this.getClass().getSimpleName() + "could not delete id: " + id);
        }
        LOGGER.debug("{} with id {} was deleted from db", entity.get().getClass().getSimpleName(), entity.get().getId());
        repository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBulk(List<DTO> dtos) {
        List<Entity> entities = dtos.stream().map(mapper::toEntity).collect(Collectors.toList());
        LOGGER.debug("Entities {} inserted into db", entities.get(0).getClass().getSimpleName());
        repository.saveAll(entities);
    }
}
