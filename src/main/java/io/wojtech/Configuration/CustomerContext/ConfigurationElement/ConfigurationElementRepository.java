package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-08-14.
 */
public interface ConfigurationElementRepository extends JpaRepository<ConfigurationElement, ConfigurationElement.ConfigurationElementId> {
}
