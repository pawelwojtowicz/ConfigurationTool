package io.wojtech.Configuration.Module;


import io.wojtech.Configuration.Device.Device;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany( mappedBy = "DeviceModules")
    private Set<Device> Devices;

    public Module() {
        ModuleId = 0;
        Name = "";
        Description = "";
    }

    public Module(long moduleId, String name, String description, Set<Device> devices ) {
        ModuleId = moduleId;
        Name = name;
        Description = description;
        Devices = devices;
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

    public Set<Device> getDevices() {
        return Devices;
    }

    public void setDevices(Set<Device> devices) {
        Devices = devices;
    }
}
