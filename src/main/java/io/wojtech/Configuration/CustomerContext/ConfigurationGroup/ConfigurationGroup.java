package io.wojtech.Configuration.CustomerContext.ConfigurationGroup;

import io.wojtech.Configuration.ConfigurationItem.ConfigurationItem;
import io.wojtech.Configuration.CustomerContext.Configuration.Configuration;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2017-09-22.
 */
@Entity
public class ConfigurationGroup {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    long configurationGroupId;
    String name;
    String description;
    long baselineId;
    long customerId;

    @ManyToMany( cascade = CascadeType.PERSIST)
    @JoinTable( name = "ConfigurationGroupSetup",
            joinColumns = @JoinColumn(name = "configurationGroupId", referencedColumnName = "configurationGroupId"),
            inverseJoinColumns = @JoinColumn( name ="configurationId", referencedColumnName = "configurationId"))
    private Set<Configuration> configurations;


    public ConfigurationGroup() {
        this.configurationGroupId = 0;
        this.name = "";
        this.description = "";
        this.baselineId = 0;
        this.customerId = 0;
    }


    public long getConfigurationGroupId() {
        return configurationGroupId;
    }

    public void setConfigurationGroupId(long configurationGroupId) {
        this.configurationGroupId = configurationGroupId;
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

    public long getBaselineId() {
        return baselineId;
    }

    public void setBaselineId(long baselineId) {
        this.baselineId = baselineId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Set<Configuration> getConfigItems() {
        return configurations;
    }

    public void setConfigItems(Set<Configuration> configItems) {
        this.configurations = configItems;
    }
}

