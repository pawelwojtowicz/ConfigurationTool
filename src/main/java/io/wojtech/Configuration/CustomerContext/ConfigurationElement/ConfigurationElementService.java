package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import io.wojtech.Configuration.CustomerContext.Configuration.Configuration;
import io.wojtech.Configuration.CustomerContext.Configuration.ConfigurationRepository;
import io.wojtech.Configuration.CustomerContext.ConfigurationElementParameter.ConfigurationElementParameter;
import io.wojtech.Configuration.CustomerContext.ConfigurationElementParameter.ConfigurationElementParameterRepository;
import io.wojtech.Configuration.Template.Template;
import io.wojtech.Configuration.Template.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@Service
public class ConfigurationElementService {

    @Autowired
    ConfigurationElementRepository configurationElementRepository;

    @Autowired
    ConfigurationRepository configurationRepository;

    @Autowired
    TemplateRepository templateRepository;

    @Autowired
    ConfigurationElementParameterRepository configElementRepository;


    void addConfigrationElement(ConfigurationElement configurationElement )
    {
        Configuration parentConfiguration = configurationRepository.findOne(configurationElement.getParentConfigurationId());
        configurationElement.setParentConfiguration(parentConfiguration);

        Template template = templateRepository.findByTemplateId(configurationElement.getTemplateId());
        configurationElement.setTemplate(template);

        Set<ConfigurationElementParameter> configElementParameters = configurationElement.getConfigurationElementParameters();


        ConfigurationElement addedElement = configurationElementRepository.save(configurationElement);

        for( ConfigurationElementParameter configurationElementParameter : configElementParameters) {
            configurationElementParameter.setConfigurationElementId(addedElement.getConfigurationElementId());
            configElementRepository.save(configurationElementParameter);
        }

    }

    void updateConfigurationElement( ConfigurationElement configurationElement)
    {
        configurationElementRepository.save(configurationElement);
    }

    void deleteConfigurationElement(long configurationElementId)
    {
        configurationElementRepository.delete(configurationElementId);
    }

    List<ConfigurationElement> getAllConfigurationElements()
    {
        return configurationElementRepository.findAll();
    }

    List<ConfigurationElement> getElementsForConfiguration( long configurationId )
    {
        List<ConfigurationElement> elementsForConfiguration = new ArrayList<ConfigurationElement>();

        elementsForConfiguration.addAll(configurationElementRepository.findAll().stream()
                .filter(configurationElement -> configurationElement.getParentConfigurationId() == configurationId)
                .collect(Collectors.toList()));

        return elementsForConfiguration;
    }

}
