package io.wojtech.Configuration.CustomerContext.ConfigurationElementParameter;

import io.wojtech.Configuration.CustomerContext.ConfigurationElement.ConfigurationElement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-09-08.
 */
@Entity
public class ConfigurationElementParameter {

    @Embeddable
    public static class ConfigurationElementParameterId implements Serializable {

        public ConfigurationElementParameterId() {
            this.configurationElementId = 0;
            this.templateParameterId = 0;
            this.baselineId = 0;
        }

        public ConfigurationElementParameterId(long configurationElementId, long templateParameterId, long baselineId) {
            this.configurationElementId = configurationElementId;
            this.templateParameterId = templateParameterId;
            this.baselineId = baselineId;
        }

        @Column( name = "configurationElementId", nullable = false)
        public long configurationElementId;

        @Column( name = "templateParameterId", nullable = false)
        public long templateParameterId;

        @Column( name = "baselineId", nullable = false)
        public long baselineId;
    }

    @EmbeddedId
    ConfigurationElementParameterId configElementId;


    @ManyToOne()
    @JoinColumn( name = "configurationElementId", insertable = false, updatable = false )
    ConfigurationElement parentConfigElement;

    String templateParameterValue;

    public ConfigurationElementParameter() {
        this.configElementId = new ConfigurationElementParameterId();
        this.templateParameterValue = "";
    }

    public ConfigurationElementParameter(long configurationElementParameterId, long templateParameterId, long baselineId, String templateParameterValue) {
        this.configElementId = new ConfigurationElementParameterId(configurationElementParameterId, templateParameterId, baselineId);
        this.templateParameterValue = templateParameterValue;
    }

    public long getConfigurationElementId() {
        return this.configElementId.configurationElementId;
    }

    public void setConfigurationElementId(long configurationElementId) {
        this.configElementId.configurationElementId = configurationElementId;
    }

    public long getTemplateParameterId() {
        return this.configElementId.templateParameterId;
    }

    public void setTemplateParameterId(long templateParameterId) {
        this.configElementId.templateParameterId = templateParameterId;
    }

    public long getBaselineId() {
        return this.configElementId.baselineId;
    }

    public void setBaselineId(long baselineId) {
        this.configElementId.baselineId = baselineId;
    }

    public String getTemplateParameterValue() {
        return templateParameterValue;
    }

    public void setTemplateParameterValue(String templateParameterValue) {
        this.templateParameterValue = templateParameterValue;
    }

    public ConfigurationElementParameterId getConfigElementId() {
        return configElementId;
    }

    public void setConfigElementId(ConfigurationElementParameterId configElementId) {
        this.configElementId = configElementId;
    }

    public ConfigurationElement getParentConfigElement() {
        return parentConfigElement;
    }

    public void setParentConfigElement(ConfigurationElement parentConfigElement) {
        this.parentConfigElement = parentConfigElement;
    }
}
