package io.wojtech.Configuration.CustomerContext.ConfigurationGroupSetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2017-09-22.
 */
@Service
public class ConfigurationGroupSetupService {

    @Autowired
    ConfigurationGroupSetupRepository configurationGroupSetupRepository;

    void addConfigurationGroupElement( ConfigurationGroupSetup configurationGroupSetup) {
        configurationGroupSetupRepository.save(configurationGroupSetup);
    }

    void deleteConfigurationGroupElement( ConfigurationGroupSetup configurationGroupSetup) {
        configurationGroupSetupRepository.delete(configurationGroupSetup);
    }
}
