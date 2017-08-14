package io.wojtech.Configuration.Module;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ModuleId;
    private String Name;

    public long getModuleId() {
        return ModuleId;
    }

    public void setModuleId(long moduleId) {
        ModuleId = moduleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(long deviceId) {
        DeviceId = deviceId;
    }

    private String Description;
    private long DeviceId;
}
