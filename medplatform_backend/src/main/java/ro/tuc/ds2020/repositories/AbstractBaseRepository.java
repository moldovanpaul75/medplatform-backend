package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;


@NoRepositoryBean
public interface AbstractBaseRepository<T extends Object, UUID> extends JpaRepository<T, UUID> {

    @Query("select t from #{#entityName} t where t.id = ?1")
    List<T> findAllById(String attribute);
}
