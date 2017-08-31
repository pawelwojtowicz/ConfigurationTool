package io.wojtech.Configuration.ConfigurationItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.wojtech.Configuration.Module.Module;

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

    public long getConfigurationItemId() {
        return configurationItemId;
    }

    public void setConfigurationItemId(long configurationItemId) {
        this.configurationItemId = configurationItemId;
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

    @ManyToMany( mappedBy = "configItems", fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Module> modules;

    public ConfigurationItem() {
        configurationItemId = 0;
        Name = "";
        Description = "";
        ExportType = "";
        FileName = "";
    }
    public ConfigurationItem(long configurationTypeId, String name, String description, String exportType, String fileName) {
        configurationItemId = configurationTypeId;
        Name = name;
        Description = description;
        ExportType = exportType;
        FileName = fileName;
    }

    public long getConfigurationTypeId() {
        return configurationItemId;
    }

    public void setConfigurationTypeId(long configurationTypeId) {
        configurationItemId = configurationTypeId;
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
}
