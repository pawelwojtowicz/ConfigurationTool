package io.wojtech.Configuration.CustomerContext.ConfigurationGroupSetup;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by user on 2017-09-22.
 */
@Entity
public class ConfigurationGroupSetup {

    @Embeddable
    public static class ConfigGroupSetupId implements Serializable {
        @Column(name = "configurationGroupId", nullable = false)
        long configurationGroupId;
        @Column(name = "configurationId", nullable = false)
        long configurationId;

        public ConfigGroupSetupId() {
            this.configurationGroupId = 0;
            this.configurationId = 0;
        }

        public ConfigGroupSetupId(long configurationGroupId, long configurationId) {
            this.configurationGroupId = configurationGroupId;
            this.configurationId = configurationId;
        }

    }

    @EmbeddedId
    ConfigGroupSetupId configGroupSetupId;

    public ConfigurationGroupSetup() {
        this.configGroupSetupId = new ConfigGroupSetupId(0,0);
    }

    public ConfigurationGroupSetup(long configurationGroupId, long configurationId) {
        this.configGroupSetupId = new ConfigGroupSetupId(configurationGroupId,configurationId);
    }

    public long getConfigurationGroupId() {
        return configGroupSetupId.configurationGroupId;
    }

    public void setConfigurationGroupId(long configurationGroupId) {
        this.configGroupSetupId.configurationGroupId = configurationGroupId;
    }

    public long getConfigurationId() {
        return configGroupSetupId.configurationId;
    }

    public void setConfigurationId(long configurationId) {
        this.configGroupSetupId.configurationId = configurationId;
    }
}
