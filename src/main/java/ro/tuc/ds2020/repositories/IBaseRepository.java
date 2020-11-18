package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ro.tuc.ds2020.entities.BaseEntity;


@NoRepositoryBean
public interface IBaseRepository<T extends BaseEntity, UUID> extends JpaRepository<T, UUID> {
}
