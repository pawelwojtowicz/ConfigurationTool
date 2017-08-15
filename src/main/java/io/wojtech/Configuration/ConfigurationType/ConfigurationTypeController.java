package io.wojtech.Configuration.ConfigurationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.Config;

import java.util.List;

/**
 * Created by user on 2017-08-15.
 */
@RestController
public class ConfigurationTypeController {
    @Autowired
    private ConfigurationTypeService configurationTypeService;

    @RequestMapping( method = RequestMethod.POST , value = "/configurationtype")
    void addConfigurationType(@RequestBody ConfigurationType configurationType)
    {
        configurationTypeService.addConfigurationType(configurationType);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/configurationtype")
    void updateConfigurationType(@RequestBody ConfigurationType configurationType)
    {
        configurationTypeService.updateConfigurationType(configurationType);
    }


    @RequestMapping( method = RequestMethod.DELETE , value = "/configurationtype/{configurationTypeId}")
    void deleteConfigurationType(@PathVariable long configurationTypeId)
    {
        configurationTypeService.deleteConfigurationType(configurationTypeId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configurationtype")
    public List<ConfigurationType> getAllConfigurationTypes()
    {
        return configurationTypeService.getAllConfigurationTypes();
    }
}