package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */


@Entity
public class ConfigurationElement {

    @Embeddable
    public class ConfigurationElementId implements Serializable
    {
        @Column( name = "ConfigurationId", nullable = false)
        public long ConfigurationId;

        @Column(name = "TemplateId",nullable = false)
        public long TemplateId;
    }
    @EmbeddedId
    private ConfigurationElementId configurationElement;

    public long getConfigurationId() {
        return configurationElement.ConfigurationId;
    }

    public void setConfigurationId(long configurationId) {
        configurationElement.ConfigurationId = configurationId;
    }

    public long getTemplateId() {
        return configurationElement.TemplateId;
    }

    public void setTemplateId(long templateId) {
        configurationElement.TemplateId = templateId;
    }


}
