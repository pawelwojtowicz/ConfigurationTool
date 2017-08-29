package io.wojtech.Configuration.Device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public void addDevice(Device device)
    {
        deviceRepository.save(device);
    }

    public void updateDevice(Device device)
    {
        deviceRepository.save(device);
    }

    public List<Device> getDevices()
    {
        return deviceRepository.findAll();
    }

    public Device getDeviceById( long deviceId) {
        return deviceRepository.findByDeviceId( deviceId);
    }

    public void deleteDevice( long deviceId)
    {
        deviceRepository.delete(deviceId);
    }


}
