package io.wojtech.Configuration.CustomerContext.Node;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.wojtech.Configuration.CustomerContext.ConfigurationGroup.*;
import io.wojtech.Configuration.Device.Device;

@Entity
public class Node {
	
	@Id
	@Column(name = "NODE_ID",unique=true,columnDefinition="VARCHAR(24)")
	String nodeStringId;
	String description;
		 
	long configurationGroupId;
		
	@ManyToOne( )
	@JoinColumn( name = "configurationGroupId",  insertable = false, updatable = false)
	ConfigurationGroup nodeConfiguration;
	
	long deviceId;

	@ManyToOne( )
	@JoinColumn( name = "deviceId",  insertable = false, updatable = false)
    Device device;
    
	public Node() {
		this.nodeStringId = "";
		this.description = "";
		this.configurationGroupId = 0;
		this.nodeConfiguration = null;
		this.deviceId = 0;
		this.device = null;
	}

	public String getNodeStringId() {
		return nodeStringId;
	}

	public void setNodeStringId(String nodeStringId) {
		this.nodeStringId = nodeStringId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getConfigurationGroupId() {
		return configurationGroupId;
	}

	public void setConfigurationGroupId(long configurationGroupId) {
		this.configurationGroupId = configurationGroupId;
	}

	public ConfigurationGroup getNodeConfiguration() {
		return nodeConfiguration;
	}

	public void setNodeConfiguration(ConfigurationGroup nodeConfiguration) {
		this.nodeConfiguration = nodeConfiguration;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	
	
}
