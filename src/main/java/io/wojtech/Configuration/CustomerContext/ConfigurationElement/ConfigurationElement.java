package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */


@Entity
public class ConfigurationElement {

    @Embeddable
    static public class ConfigurationElementId implements Serializable
    {
        public ConfigurationElementId(long configurationId, long templateId) {
            ConfigurationId = configurationId;
            TemplateId = templateId;
        }

        @Column( name = "ConfigurationId", nullable = false)
        public long ConfigurationId;

        @Column(name = "TemplateId",nullable = false)
        public long TemplateId;
    }
    @EmbeddedId
    private ConfigurationElementId configurationElementId;

    ConfigurationElement(long configurationId, long templateId )
    {
        configurationElementId = new ConfigurationElementId(configurationId,templateId);
    }

    public long getConfigurationId() {
        return configurationElementId.ConfigurationId;
    }

    public void setConfigurationId(long configurationId) {
        configurationElementId.ConfigurationId = configurationId;
    }

    public long getTemplateId() {
        return configurationElementId.TemplateId;
    }

    public void setTemplateId(long templateId) {
        configurationElementId.TemplateId = templateId;
    }


}
