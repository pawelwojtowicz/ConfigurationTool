package io.wojtech.Configuration.ModuleConfigItemSetup;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-31.
 */
@Entity
@Table( name = "ModuleConfigItemSetup")
public class ModuleConfigItemSetup {

    @Embeddable
    static public class ModuleConfigItemSetupId implements Serializable {
        @Column(name = "ModuleId", nullable = false)
        public long moduleId;
        @Column(name = "ConfigurationItemId", nullable = false)
        public long ConfigurationItemId;

    }

    @EmbeddedId
    ModuleConfigItemSetupId moduleConfigSetupId;

    public ModuleConfigItemSetup() {
        moduleConfigSetupId = new ModuleConfigItemSetupId();
        this.moduleConfigSetupId.moduleId = 0;
        this.moduleConfigSetupId.ConfigurationItemId = 0;
    }

    public ModuleConfigItemSetup(long moduleId, long configurationItemId) {
        moduleConfigSetupId = new ModuleConfigItemSetupId();
        this.moduleConfigSetupId.moduleId = moduleId;
        this.moduleConfigSetupId.ConfigurationItemId = configurationItemId;
    }

    public long getModuleId() {
        return moduleConfigSetupId.moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleConfigSetupId.moduleId = moduleId;
    }

    public long getConfigurationItemId() {
        return moduleConfigSetupId.ConfigurationItemId;
    }

    public void setConfigurationItemId(long configurationItemId) {
        moduleConfigSetupId.ConfigurationItemId = configurationItemId;
    }

}
