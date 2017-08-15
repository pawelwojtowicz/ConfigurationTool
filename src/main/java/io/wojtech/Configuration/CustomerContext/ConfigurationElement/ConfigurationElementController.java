package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@RestController
public class ConfigurationElementController {

    @Autowired
    ConfigurationElementRepository configurationElementRepository;

    @RequestMapping( method = RequestMethod.POST , value = "/configurationelement")
    void addConfigrationElement(@RequestBody ConfigurationElement configurationElement )
    {
        configurationElementRepository.save(configurationElement);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/configurationelement")
    void updateConfigurationElement( @RequestBody ConfigurationElement configurationElement)
    {
        configurationElementRepository.save(configurationElement);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/configurationelement/{configurationId}/{templateId}")
    void deleteConfigurationElement(@PathVariable long configurationId, @PathVariable long templateId)
    {
        ConfigurationElement.ConfigurationElementId configurationElementId = new ConfigurationElement.ConfigurationElementId(configurationId,templateId);
        configurationElementRepository.delete(configurationElementId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configurationelement")
    List<ConfigurationElement> getAllConfigurationElements()
    {
        return configurationElementRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configurationelement/{configurationId}")
    List<ConfigurationElement> getElementsForConfiguration( @PathVariable long configurationId )
    {
        List<ConfigurationElement> elementsForConfiguration = new ArrayList<ConfigurationElement>();

        elementsForConfiguration.addAll(configurationElementRepository.findAll().stream()
                .filter(configurationElement -> configurationElement.getConfigurationId() == configurationId)
                .collect(Collectors.toList()));

        return elementsForConfiguration;
    }

}
