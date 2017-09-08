package io.wojtech.Configuration.CustomerContext.Configuration;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Configuration {

    @Embeddable
    public static class ConfigId implements Serializable
    {
        @Column(name = "configurationId")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        public long configurationId;

        @Column(name = "baselineId", nullable = false)
        public long baselineId;

        public ConfigId() {
            this.configurationId = 0;
            this.baselineId = 0;
        }
    }

    @EmbeddedId
    ConfigId configId;

    private String name;
    private String description;
    private long customerId;

    public Configuration() {
        configId = new ConfigId();
        configId.configurationId = 0;
        configId.baselineId= 0;
        this.name = name;
        this.description = "";
        customerId = 0;
    }

    public Configuration(long configurationId, long baselineNumber, String name, String description, long customerId) {
        configId = new ConfigId();
        configId.configurationId = configurationId;
        configId.baselineId= baselineNumber;
        this.name = name;
        this.description = description;
        this.customerId = customerId;
    }

    public long getConfigurationId() {
        return configId.configurationId;
    }

    public void setConfigurationId(long configurationId) {
        configId.configurationId = configurationId;
    }

    public long getBaselineId() {
        return configId.baselineId;
    }

    public void setBaselineId(long baselineId) {
        configId.baselineId = baselineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
