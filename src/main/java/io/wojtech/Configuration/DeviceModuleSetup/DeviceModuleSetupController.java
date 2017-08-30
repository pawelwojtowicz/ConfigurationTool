package io.wojtech.Configuration.DeviceModuleSetup;

import io.wojtech.Configuration.Module.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2017-08-30.
 */
@RestController
public class DeviceModuleSetupController {

    @Autowired
    DeviceModuleSetupService service;

    @RequestMapping( method= RequestMethod.POST, value = "/devicemodulesetup/{deviceId}/{moduleId}")
    public void addDeviceModuleSetup(@PathVariable long deviceId , @PathVariable long moduleId)
    {
        service.addDeviceModuleSetup(new DeviceModuleSetup( deviceId, moduleId ));
    }

    @RequestMapping( method= RequestMethod.DELETE, value = "/devicemodulesetup/{deviceId}/{moduleId}")
    public void deleteDeviceModuleSetup(@PathVariable long deviceId , @PathVariable long moduleId)
    {
        service.deleteDeviceModuleSetup(new DeviceModuleSetup( deviceId, moduleId ));
    }
}
