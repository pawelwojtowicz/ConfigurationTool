package io.wojtech.Configuration.Device;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Device() {
        DeviceId= 0;
        Name = "";
        Description = "";
    }

    public Device(long moduleId, String name, String description) {
        DeviceId = moduleId;
        Name = name;
        Description = description;
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
}
