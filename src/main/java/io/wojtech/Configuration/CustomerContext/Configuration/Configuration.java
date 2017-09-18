package io.wojtech.Configuration.CustomerContext.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.wojtech.Configuration.CustomerContext.ConfigurationElement.ConfigurationElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Configuration {

    @Id
    @Column(name = "configurationId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long configurationId;

    @Column(name = "baselineId", nullable = false)
    public long baselineId;

    private String name;
    private String description;
    private long customerId;

    @OneToMany(mappedBy = "parentConfiguration", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="parentConfiguration")
    Set<ConfigurationElement> configurationElements;


    public Configuration() {
        this.configurationId = 0;
        this.baselineId= 0;
        this.name = name;
        this.description = "";
        customerId = 0;
    }

    public Configuration(long configurationId, long baselineNumber, String name, String description, long customerId) {
        this.configurationId = configurationId;
        this.baselineId= baselineNumber;
        this.name = name;
        this.description = description;
        this.customerId = customerId;
    }

    public long getConfigurationId() {
        return this.configurationId;
    }

    public void setConfigurationId(long configurationId) {
        this.configurationId = configurationId;
    }

    public long getBaselineId() {
        return this.baselineId;
    }

    public void setBaselineId(long baselineId) {
        this.baselineId = baselineId;
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

    public Set<ConfigurationElement> getConfigurationElements() {
        return configurationElements;
    }

    public void setConfigurationElements(Set<ConfigurationElement> configurationElements) {
        this.configurationElements = configurationElements;
    }
}
