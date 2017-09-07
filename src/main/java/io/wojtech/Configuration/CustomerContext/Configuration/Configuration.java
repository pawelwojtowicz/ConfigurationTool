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
        @Column(name = "configurationId", nullable = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long configurationId;

        @Column(name = "baselineId", nullable = false)
        private long baselineId;

        public ConfigId() {
            this.configurationId = 0;
            this.baselineId = 0;
        }

        public long getConfigurationId() {
            return configurationId;
        }

        public void setConfigurationId(long configurationId) {
            this.configurationId = configurationId;
        }

        public long getBaselineId() {
            return baselineId;
        }

        public void setBaselineId(long baselineId) {
            this.baselineId = baselineId;
        }
    }

    @EmbeddedId
    ConfigId configId;
    private String name;
    private String description;
    private long CustomerId;

    public Configuration() {
        configId = new ConfigId();
        configId.configurationId = 0;
        configId.baselineId= 0;
        this.name = name;
        this.description = description;
        CustomerId = 0;
    }

    public Configuration(long configurationId, long baselineNumber, String name, String description, long customerId) {
        configId = new ConfigId();
        configId.configurationId = configurationId;
        configId.baselineId= baselineNumber;
        this.name = name;
        this.description = description;
        CustomerId = customerId;
    }

    public long getConfigurationId() {
        return configId.configurationId;
    }

    public void setConfigurationId(long configurationId) {
        configId.configurationId = configurationId;
    }

    public long getBaselineNumber() {
        return configId.baselineId;
    }

    public void setBaselineNumber(long baselineNumber) {
        configId.baselineId = baselineNumber;
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
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }
}
