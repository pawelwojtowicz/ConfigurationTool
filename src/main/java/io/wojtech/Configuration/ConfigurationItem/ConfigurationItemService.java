package io.wojtech.Configuration.ConfigurationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.Config;

import java.util.List;

/**
 * Created by user on 2017-08-15.
 */
@Service
public class ConfigurationItemService {
    @Autowired
    ConfigurationItemRepository configurationItemRepository;

    ConfigurationItem addConfigurationType( ConfigurationItem configurationItem)
    {
        return configurationItemRepository.save(configurationItem);
    }

    void updateConfigurationType( ConfigurationItem configurationItem)
    {
        configurationItemRepository.save(configurationItem);
    }

    void deleteConfigurationType( long configurationTypeId)
    {
        configurationItemRepository.delete(configurationTypeId);
    }

    List<ConfigurationItem> getAllConfigurationTypes()
    {
        return configurationItemRepository.findAll();
    }

    ConfigurationItem getConfigurationItemById(long configItemId) {
        return configurationItemRepository.findByConfigurationItemId(configItemId);
    }


}
