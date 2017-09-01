package io.wojtech.Configuration.ConfigurationItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.wojtech.Configuration.Module.Module;
import io.wojtech.Configuration.Parameter.Parameter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class ConfigurationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long configurationItemId;
    private String Name;
    private String Description;
    private String ExportType;
    private String FileName;

    @ManyToMany( mappedBy = "configItems", fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Module> modules;

    @OneToMany(mappedBy = "configurationItem", cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    private Set<Parameter> configItemParameters;

    public ConfigurationItem() {
        configurationItemId = 0;
        Name = "";
        Description = "";
        ExportType = "";
        FileName = "";
    }
    public ConfigurationItem(long configurationItemId, String name, String description, String exportType, String fileName) {
        configurationItemId = configurationItemId;
        Name = name;
        Description = description;
        ExportType = exportType;
        FileName = fileName;
    }

    public long getConfigurationItemId() {
        return configurationItemId;
    }

    public void setConfigurationItemId(long configurationItemId) {
        this.configurationItemId = configurationItemId;
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

    public String getExportType() {
        return ExportType;
    }

    public void setExportType(String exportType) {
        ExportType = exportType;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public Set<Parameter> getConfigItemParameters() {
        return configItemParameters;
    }

    public void setConfigItemParameters(Set<Parameter> configItemParameters) {
        this.configItemParameters = configItemParameters;
    }
}
