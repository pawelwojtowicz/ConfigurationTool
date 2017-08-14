package io.wojtech.Configuration.Parameter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
public interface ParameterRepository extends JpaRepository<Parameter,Long> {
    List<Parameter> findByConfigurationTypeId(long ConfigurationTypeId);
}
