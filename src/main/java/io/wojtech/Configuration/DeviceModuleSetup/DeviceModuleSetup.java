package io.wojtech.Configuration.DeviceModuleSetup;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-28.
 */
@Entity
@Table( name = "DeviceModuleSetup")
public class DeviceModuleSetup {
    @Embeddable
    static public class DeviceModuleSetupId implements Serializable{
        @Column( name = "DeviceId", nullable = false)
        public long deviceId;
        @Column(name = "ModuleId", nullable = false)
        public long moduleId;
    }

    public DeviceModuleSetupId getSetupId() {
        return setupId;
    }

    public void setSetupId(DeviceModuleSetupId setupId) {
        this.setupId = setupId;
    }

    @EmbeddedId
    private DeviceModuleSetupId setupId;

    public DeviceModuleSetup() {
        setupId = new DeviceModuleSetupId();
        setupId.deviceId = 0;
        setupId.moduleId = 0;
    }

    public DeviceModuleSetup(long deviceId, long moduleId) {
        setupId = new DeviceModuleSetupId();
        setupId.deviceId = deviceId;
        setupId.moduleId = moduleId;
    }

    public long getDeviceId() {
        return setupId.deviceId;
    }

    public void setDeviceId(long deviceId) {
        setupId.deviceId = deviceId;
    }

    public long getModuleId() {
        return setupId.moduleId;
    }

    public void setModuleId(long moduleId) {
        setupId.moduleId = moduleId;
    }
}
