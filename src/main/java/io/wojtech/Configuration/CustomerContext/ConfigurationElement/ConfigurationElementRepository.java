package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@Repository
public interface ConfigurationElementRepository extends JpaRepository<ConfigurationElement, Long> {
	List<ConfigurationElement> findByParentConfigurationId(long configurationId);
}
