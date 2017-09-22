package io.wojtech.Configuration.CustomerContext.ConfigurationGroupSetup;

import io.wojtech.Configuration.CustomerContext.ConfigurationGroup.ConfigurationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

/**
 * Created by user on 2017-09-22.
 */
@RestController
public class ConfigurationGroupSetupController {

    @Autowired
    ConfigurationGroupSetupService configurationGroupService;

    @RequestMapping( method = RequestMethod.POST , value = "/configurationgroupsetup/{configurationGroupId}/{configurationId}")
    void addConfigurationToGroup(@PathVariable long configurationGroupId, @PathVariable long configurationId) {
        ConfigurationGroupSetup configurationGroupItem = new ConfigurationGroupSetup(configurationGroupId, configurationId);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "configurationgroupsetup/{configurationGroupId}/{configurationId}")
    void removeConfigurationFromGroup(@PathVariable long configurationGroupId, @PathVariable long configurationId) {
        ConfigurationGroupSetup configGroupItem = new ConfigurationGroupSetup(configurationGroupId,configurationId);
        configurationGroupService.deleteConfigurationGroupElement(configGroupItem);
    }
}
