package io.wojtech.Configuration.CustomerContext.Configuration;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-08-14.
 */
public interface ConfigurationRepository extends JpaRepository<Configuration,Long> {

}
