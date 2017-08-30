package io.wojtech.Configuration.DeviceModuleSetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2017-08-30.
 */
@Service
public class DeviceModuleSetupService {
    @Autowired
    DeviceModuleSetupRepository repository;

    public void addDeviceModuleSetup(DeviceModuleSetup deviceModuleSetup) {
        repository.save(deviceModuleSetup );
    }

    void deleteDeviceModuleSetup( DeviceModuleSetup devicemoduleSetup ) {
        repository.delete(devicemoduleSetup.getSetupId());
    }

}
