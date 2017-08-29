package io.wojtech.Configuration.Device;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-08-14.
 */
public interface DeviceRepository extends JpaRepository<Device,Long> {
    Device findByDeviceId( long DeviceId );
}
