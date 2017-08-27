package io.wojtech.Configuration.ConfigurationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class ConfigurationType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ConfigurationTypeId;
    private String Name;
    private String Description;
    private String ExportType;

    public ConfigurationType(long configurationTypeId, String name, String description, String exportType) {
        ConfigurationTypeId = configurationTypeId;
        Name = name;
        Description = description;
        ExportType = exportType;
    }

    public long getConfigurationTypeId() {
        return ConfigurationTypeId;
    }

    public void setConfigurationTypeId(long configurationTypeId) {
        ConfigurationTypeId = configurationTypeId;
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
