package io.wojtech.Configuration.Parameter;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-12.
 */
public class Parameter {
    public Parameter(String name, String path, String type, int configurationTypeID, String value) {
        Name = name;
        Path = path;
        Type = type;
        ConfigurationTypeID = configurationTypeID;
        Value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ParameterId;
    private String Name;
    private String Path;
    private String Type;
    private String Unit;
    private String Value;
    private String Description;
    private int ConfigurationTypeID;
    private long ValidFromReleaseId;
    private long ValidToReleaseId;

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public String getName() {
        return Name;
    }

    public long getParameterId() {
        return ParameterId;
    }

    public void setParameterId(long parameterId) {
        ParameterId = parameterId;
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

    public int getConfigurationTypeID() {
        return ConfigurationTypeID;
    }

    public void setConfigurationTypeID(int configurationTypeID) {
        ConfigurationTypeID = configurationTypeID;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
