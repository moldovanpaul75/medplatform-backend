package ro.tuc.ds2020.dtos.builders;

import org.springframework.data.repository.NoRepositoryBean;
import ro.tuc.ds2020.dtos.BaseDTO;
import ro.tuc.ds2020.entities.BaseEntity;

@NoRepositoryBean
public interface IMapper<DTO extends BaseDTO, Entity extends BaseEntity> {

    public abstract Entity toEntity(DTO dto);

    public abstract DTO toDTO(Entity entity);

}
