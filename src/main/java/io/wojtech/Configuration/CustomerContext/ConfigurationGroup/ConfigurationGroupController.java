package io.wojtech.Configuration.CustomerContext.ConfigurationGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 2017-09-22.
 */
@RestController
public class ConfigurationGroupController {
    @Autowired
    ConfigurationGroupService configurationGroupService;

    @RequestMapping( method = RequestMethod.POST , value = "/configurationgroup")
    void addConfigurationGroup(ConfigurationGroup configurationGroup) {
        configurationGroupService.addConfigurationGroup(configurationGroup);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/configurationgroup")
    void updateConfigurationGroup( ConfigurationGroup configurationGroup) {
        configurationGroupService.modifyConfigurationGroup(configurationGroup);
    }

    @RequestMapping( method = RequestMethod.DELETE , value = "/configurationgroup/{configurationGroupId}")
    void deleteConfigurationGroup( @PathVariable long configurationGroupId) {
        configurationGroupService.deleteConfigurationGroup(configurationGroupId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configurationgroup/{configurationGroupId}")
    ConfigurationGroup getConfigurationGroupById( @PathVariable long configurationGroupId) {
        return configurationGroupService.getConfigurationGroup(configurationGroupId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/configurationgroup")
    List<ConfigurationGroup> getAllConfigurationGroups() {
        return configurationGroupService.getAllConfigurationGroups();
    }

}
