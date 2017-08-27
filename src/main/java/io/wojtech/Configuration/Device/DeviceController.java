package io.wojtech.Configuration.Device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping( method= RequestMethod.POST, value = "/devices")
    public void addDevice(@RequestBody Device device)
    {
        deviceService.addDevice(device);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/devices")
    public void updateDevice(@RequestBody Device device)
    {
        deviceService.updateDevice(device);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/devices")
    public List<Device> getDevice()
    {
        return deviceService.getDevices();
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/devices/{deviceId}")
    public void deleteDevice( @PathVariable long deviceId)
    {
        deviceService.deleteDevice(deviceId);
    }


}
