package io.wojtech.Configuration.Export;

import io.wojtech.Configuration.Module.Module;
import io.wojtech.Configuration.Device.Device;
import io.wojtech.Configuration.ConfigurationItem.ConfigurationItem;

public class ExportToolbox {
	
	public static ConfigurationItem findConfiguration( Device device, long configurationItemId) {
		
		for( Module module : device.getDeviceModules() ) {
			for ( ConfigurationItem configItem : module.getConfigItems() ) {
				if ( configurationItemId == configItem.getConfigurationItemId() ) {
					return configItem;
				}
			}
		}
		
		return null;
	}

}
