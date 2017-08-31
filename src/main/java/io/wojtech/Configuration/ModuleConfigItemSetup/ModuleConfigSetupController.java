package io.wojtech.Configuration.ModuleConfigItemSetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2017-08-31.
 */
@RestController
public class ModuleConfigSetupController {
    @Autowired
    ModuleConfigSetupService service;

    @RequestMapping( method= RequestMethod.POST, value = "/moduleconfigitemsetup/{moduleId}/{configItemId}")
    public void addDeviceModuleSetup(@PathVariable long moduleId, @PathVariable long configItemId)
    {
        service.addModuleConfigItemSetup(new ModuleConfigItemSetup( moduleId, configItemId));
    }

    @RequestMapping( method= RequestMethod.DELETE, value = "/moduleconfigitemsetup/{moduleId}/{configItemId}")
    public void deleteDeviceModuleSetup(@PathVariable long moduleId, @PathVariable long configItemId)
    {
        service.deleteConfigItemSetup(new ModuleConfigItemSetup(moduleId, configItemId));
    }
}
