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
    ConfigurationElementService configurationElementService;

    @RequestMapping( method = RequestMethod.POST , value = "/configurationelement")
    void addConfigrationElement(@RequestBody ConfigurationElement configurationElement )
    {
        configurationElementService.addConfigrationElement(configurationElement);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/configurationelement")
    void updateConfigurationElement( @RequestBody ConfigurationElement configurationElement)
    {
        configurationElementService.updateConfigurationElement(configurationElement);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/configurationelement/{configurationElementId}")
    void deleteConfigurationElement(@PathVariable long configurationElementId)
    {
        configurationElementService.deleteConfigurationElement(configurationElementId,0);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configurationelement")
    List<ConfigurationElement> getAllConfigurationElements()
    {
        return configurationElementService.getAllConfigurationElements();
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configurationelement/{configurationId}")
    List<ConfigurationElement> getElementsForConfiguration( @PathVariable long configurationId )
    {
        return configurationElementService.getElementsForConfiguration(configurationId);
    }

}
