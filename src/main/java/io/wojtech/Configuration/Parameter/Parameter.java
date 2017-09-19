package io.wojtech.Configuration.Parameter;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.wojtech.Configuration.ConfigurationItem.ConfigurationItem;

import javax.persistence.*;

/**
 * Created by user on 2017-08-12.
 */
@Entity
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long parameterId;
    private String Name;
    private String Path;
    private String Type;
    private String Unit;
    private String Value;
    private String Description;
    private int genericPath;

    @ManyToOne()
    @JoinColumn(name = "configurationItemId")
    @JsonIgnoreProperties(value="configItemParameters")
    private ConfigurationItem configurationItem;

    private long ValidFromReleaseId;
    private long ValidToReleaseId;



    public Parameter() {
        parameterId = 0;
        Name = "";
        Path = "";
        Type = "";
        Unit = "";
        Value = "";
        Description = "";
        this.configurationItem = null;
        ValidFromReleaseId = 0;
        ValidToReleaseId = 0;
        genericPath = 0;
    }

    public Parameter(long parameterId, String name, String path, String type, String unit, String value, String description, ConfigurationItem configurationItem, long validFromReleaseId, long validToReleaseId) {
        this.parameterId = parameterId;
        Name = name;
        Path = path;
        Type = type;
        Unit = unit;
        Value = value;
        Description = description;
        this.configurationItem = configurationItem;
        ValidFromReleaseId = validFromReleaseId;
        ValidToReleaseId = validToReleaseId;
        genericPath = 0;
    }

    public long getParameterId() {
        return parameterId;
    }

    public void setParameterId(long parameterId) {
        this.parameterId = parameterId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ConfigurationItem getConfigurationItem() {
        return configurationItem;
    }

    public void setConfigurationItem(ConfigurationItem configurationItem) {
        this.configurationItem = configurationItem;
    }

    public long getValidFromReleaseId() {
        return ValidFromReleaseId;
    }

    public void setValidFromReleaseId(long validFromReleaseId) {
        ValidFromReleaseId = validFromReleaseId;
    }

    public long getValidToReleaseId() {
        return ValidToReleaseId;
    }

    public void setValidToReleaseId(long validToReleaseId) {
        ValidToReleaseId = validToReleaseId;
    }

    public int getGenericPath() {
        return genericPath;
    }

    public void setGenericPath(int genericPath) {
        this.genericPath = genericPath;
    }
}
