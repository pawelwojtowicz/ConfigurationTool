package io.wojtech.Configuration.CustomerContext.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@RestController
public class ConfigurationController {
    @Autowired
    private ConfigurationService configurationService;

    @RequestMapping( method = RequestMethod.POST , value = "/configuration")
    public void addConfiguration(@RequestBody Configuration configuration)
    {
        configurationService.addConfiguration(configuration);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/configuration")
    public void updateConfiguration(@RequestBody Configuration configuration)
    {
        configurationService.updateConfiguration(configuration);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/configuration/{configurationId}")
    public void deleteConfiguration(@PathVariable long configurationId)
    {
        configurationService.deleteConfiguration(configurationId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configuration")
    public List<Configuration> getAllConfigurations()
    {
        return configurationService.getAllConfigurations();
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configuration/{customerId}")
    public Configuration getConfigurationsByConfigId( @PathVariable long configurationId )
    {
        return configurationService.getConfigurationById(configurationId );
    }
}
