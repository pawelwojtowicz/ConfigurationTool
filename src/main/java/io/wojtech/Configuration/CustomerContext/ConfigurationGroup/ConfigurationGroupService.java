package io.wojtech.Configuration.CustomerContext.ConfigurationGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.Config;

import java.util.List;

/**
 * Created by user on 2017-09-22.
 */
@Service
public class ConfigurationGroupService {

    @Autowired
    ConfigurationGroupRepository configurationGroupRepository;

    void addConfigurationGroup(ConfigurationGroup configurationGroup) {
        configurationGroupRepository.save(configurationGroup);
    }

    void modifyConfigurationGroup( ConfigurationGroup configurationGroup) {
        configurationGroupRepository.save(configurationGroup);
    }

    void deleteConfigurationGroup( long configurationGroupId ) {
        configurationGroupRepository.delete(configurationGroupId);
    }

    ConfigurationGroup getConfigurationGroup( long configurationGroupId) {
        return configurationGroupRepository.findByConfigurationGroupId(configurationGroupId);
    }

    List<ConfigurationGroup> getAllConfigurationGroups() {
        return configurationGroupRepository.findAll();
    }
}
