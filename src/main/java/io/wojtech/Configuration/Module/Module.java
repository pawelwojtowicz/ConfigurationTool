package io.wojtech.Configuration.Module;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.wojtech.Configuration.Device.Device;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long moduleId;
    private String Name;
    private String Description;

    @ManyToMany( mappedBy = "deviceModules", fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Device> devices;

    public Module() {
        moduleId = 0;
        Name = "";
        Description = "";
        devices = new HashSet<Device>();
    }

    public Module(long moduleId, String name, String description, Set<Device> devices ) {
        this.moduleId = moduleId;
        Name = name;
        Description = description;
        this.devices = devices;
        this.devices = new HashSet<Device>();    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
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
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
}
