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
        configurationRepository.delete(configurationId);
    }

    List<Configuration> getAllConfigurations()
    {
        return configurationRepository.findAll();
    }

    List<Configuration> getConfigurationsForCustomer( long customerId)
    {
        List<Configuration> configurationsForCustomer = new ArrayList<Configuration>();

        configurationsForCustomer.addAll(configurationRepository.findAll().stream()
                .filter(configuration-> configuration.getCustomerId() == customerId )
                .collect(Collectors.toList()));

        return configurationsForCustomer;

    }

}
