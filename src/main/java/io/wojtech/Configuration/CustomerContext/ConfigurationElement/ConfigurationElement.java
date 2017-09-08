package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */


@Entity
public class ConfigurationElement {

    @Embeddable
    static public class ConfigElementId implements Serializable
    {
        public ConfigElementId() {
            this.configurationElementId = 0;
            this.baselineId= 0;
        }

        public ConfigElementId(long configurationElementId, long baselineId) {
            this.configurationElementId = configurationElementId;
            this.baselineId= baselineId;
        }

        @Column( name = "configurationElementId", nullable = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        public long configurationElementId;

        @Column(name = "baselineId",nullable = false)
        public long baselineId;
    }
    @EmbeddedId
    private ConfigElementId configElementId;

    long configurationId;

    long templateId;

    String genericTemplatePath;


    public ConfigurationElement() {
        this.configElementId = new ConfigElementId( 0,0);
        this.configurationId = 0;
        this.templateId = 0;
        this.genericTemplatePath = "";
    }

    public ConfigurationElement(long configurationElementId, long baselineId, long configurationId, long templateId) {
        this.configElementId = new ConfigElementId( configurationElementId, baselineId );
        this.configurationId = configurationId;
        this.templateId = templateId;
        this.genericTemplatePath = "";
    }

    public long getConfigurationElementId() {
        return configElementId.configurationElementId;
    }

    public void setConfigurationElementId(long configurationElementId) {
        this.configElementId.configurationElementId = configurationElementId;
    }

    public long getBaselineId() {
        return configElementId.baselineId;
    }

    public void setBaselineId(long baselineId) {
        this.configElementId.baselineId = baselineId;
    }

    public long getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(long configurationId) {
        this.configurationId = configurationId;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public String getGenericTemplatePath() {
        return genericTemplatePath;
    }

    public void setGenericTemplatePath(String genericTemplatePath) {
        this.genericTemplatePath = genericTemplatePath;
    }
}
