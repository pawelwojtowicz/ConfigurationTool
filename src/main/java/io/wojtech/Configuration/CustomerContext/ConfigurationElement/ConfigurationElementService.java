package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@Service
public class ConfigurationElementService {

    @Autowired
    ConfigurationElementRepository configurationElementRepository;

    void addConfigrationElement(ConfigurationElement configurationElement )
    {
        configurationElementRepository.save(configurationElement);
    }

    void updateConfigurationElement( ConfigurationElement configurationElement)
    {
        configurationElementRepository.save(configurationElement);
    }

    void deleteConfigurationElement(long configurationElementId, long baselineId)
    {
        ConfigurationElement.ConfigElementId configElementId = new ConfigurationElement.ConfigElementId(configurationElementId,baselineId);
        configurationElementRepository.delete(configElementId);
    }

    List<ConfigurationElement> getAllConfigurationElements()
    {
        return configurationElementRepository.findAll();
    }

    List<ConfigurationElement> getElementsForConfiguration( long configurationId )
    {
        List<ConfigurationElement> elementsForConfiguration = new ArrayList<ConfigurationElement>();

        elementsForConfiguration.addAll(configurationElementRepository.findAll().stream()
                .filter(configurationElement -> configurationElement.getConfigurationId() == configurationId)
                .collect(Collectors.toList()));

        return elementsForConfiguration;
    }

}
