package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 2017-08-14.
 */
@Repository
public interface ConfigurationElementRepository extends JpaRepository<ConfigurationElement, ConfigurationElement.ConfigurationElementId> {
}
