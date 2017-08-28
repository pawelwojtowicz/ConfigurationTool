package io.wojtech.Configuration.Device;


import io.wojtech.Configuration.Module.Module;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long DeviceId;
    private String Name;
    private String Description;
    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "DeviceModuleSetup",
            joinColumns = @JoinColumn(name = "DeviceId", referencedColumnName = "DeviceId"),
            inverseJoinColumns = @JoinColumn( name ="ModuleId", referencedColumnName = "ModuleId"))
    private Set<Module> DeviceModules;

    public Device() {
        DeviceId= 0;
        Name = "";
        Description = "";
    }

    public Device(long moduleId, String name, String description , Set< Module> modules ) {
        DeviceId = moduleId;
        Name = name;
        Description = description;
        DeviceModules = modules;
    }

    public long getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(long moduleId) {
        DeviceId= moduleId;
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

    public Set<Module> getDeviceModules() {
        return DeviceModules;
    }

    public void setDeviceModules(Set<Module> deviceModules) {
        DeviceModules = deviceModules;
    }
}
