package io.wojtech.Configuration.Parameter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@Repository
public interface ParameterRepository extends JpaRepository<Parameter,Long> {
    List<Parameter> findByConfigurationTypeId(long ConfigurationTypeId);
}
