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
    private String Description;
    private long DeviceId;

    public Module() {
        ModuleId = 0;
        Name = "";
        Description = "";
        DeviceId = 0;
    }

    public Module(long moduleId, String name, String description, long deviceId) {
        ModuleId = moduleId;
        Name = name;
        Description = description;
        DeviceId = deviceId;
    }

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

}
