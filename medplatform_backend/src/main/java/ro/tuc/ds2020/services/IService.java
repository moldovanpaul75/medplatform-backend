package ro.tuc.ds2020.services;

import org.springframework.data.repository.NoRepositoryBean;
import ro.tuc.ds2020.dtos.BaseDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface IService<T extends BaseDTO> {

    public abstract UUID save(T entity);
    public abstract Collection<T> findAll();
    public abstract Optional<T> findById(UUID id);
    public abstract UUID update(T dto);
    public abstract void updateById(T dto, UUID id);
    public abstract void delete(T dto);
    public abstract void deleteById(UUID id);
    public abstract void saveBulk(List<T> dtos);
}
