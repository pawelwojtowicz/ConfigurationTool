package io.wojtech.Configuration.CustomerContext.ConfigurationElementParameter;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-09-08.
 */
public interface ConfigurationElementParameterRepository extends JpaRepository<ConfigurationElementParameter, ConfigurationElementParameter.ConfigurationElementParameterId> {
}
