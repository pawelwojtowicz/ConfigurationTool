package io.wojtech.Configuration.CustomerContext.ConfigurationGroup;

import io.wojtech.Configuration.CustomerContext.ConfigurationElement.ConfigurationElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017-09-22.
 */
public interface ConfigurationGroupRepository extends JpaRepository<ConfigurationGroup, Long> {
    ConfigurationGroup findByConfigurationId(long configurationId);
}
