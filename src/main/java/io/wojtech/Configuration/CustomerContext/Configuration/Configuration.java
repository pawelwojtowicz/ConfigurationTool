package io.wojtech.Configuration.CustomerContext.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ConfigurationId;
    private long BaselineNumber;
    private String Name;
    private String Description;
    private long CustomerId;

    public Configuration(long configurationId, long baselineNumber, String name, String description, long customerId) {
        ConfigurationId = configurationId;
        BaselineNumber = baselineNumber;
        Name = name;
        Description = description;
        CustomerId = customerId;
    }

    public long getConfigurationId() {
        return ConfigurationId;
    }

    public void setConfigurationId(long configurationId) {
        ConfigurationId = configurationId;
    }

    public long getBaselineNumber() {
        return BaselineNumber;
    }

    public void setBaselineNumber(long baselineNumber) {
        BaselineNumber = baselineNumber;
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

    public long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }
}
