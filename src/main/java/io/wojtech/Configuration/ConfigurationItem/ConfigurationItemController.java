package io.wojtech.Configuration.ConfigurationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-15.
 */
@RestController
public class ConfigurationItemController {
    @Autowired
    private ConfigurationItemService configurationItemService;

    @RequestMapping( method = RequestMethod.POST , value = "/configurationitem")
    void addConfigurationType(@RequestBody ConfigurationItem configurationItem)
    {
        configurationItemService.addConfigurationType(configurationItem);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/configurationitem")
    void updateConfigurationType(@RequestBody ConfigurationItem configurationItem)
    {
        configurationItemService.updateConfigurationType(configurationItem);
    }


    @RequestMapping( method = RequestMethod.DELETE , value = "/configurationitem/{configurationTypeId}")
    void deleteConfigurationType(@PathVariable long configurationTypeId)
    {
        configurationItemService.deleteConfigurationType(configurationTypeId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configurationitem")
    public List<ConfigurationItem> getAllConfigurationTypes()
    {
        return configurationItemService.getAllConfigurationTypes();
    }

    @RequestMapping( method = RequestMethod.GET , value= "/configurationitem/{configItemId}")
    public ConfigurationItem getConfigItemById( @PathVariable long configItemId ) {
        return configurationItemService.getConfigurationItemById( configItemId);
    }
}
