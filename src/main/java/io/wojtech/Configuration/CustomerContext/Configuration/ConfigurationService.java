package io.wojtech.Configuration.CustomerContext.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@Service
public class ConfigurationService {
    @Autowired
    ConfigurationRepository configurationRepository;

    void addConfiguration(Configuration configuration)
    {
        configurationRepository.save(configuration);
    }

    void updateConfiguration(Configuration configuration)
    {
        configurationRepository.save(configuration);
    }

    void deleteConfiguration( long configurationId )
    {
        Configuration.ConfigId toDeleteId = new Configuration.ConfigId();
        toDeleteId.setConfigurationId(configurationId);
        toDeleteId.setBaselineId(0);
        configurationRepository.delete(toDeleteId);
    }

    List<Configuration> getAllConfigurations()
    {
        return configurationRepository.findAll();
    }

    Configuration getConfigurationById(long configurationId) {
        Configuration.ConfigId idx = new Configuration.ConfigId();
        idx.setConfigurationId(configurationId);
        return configurationRepository.findOne(idx);
    }


}
