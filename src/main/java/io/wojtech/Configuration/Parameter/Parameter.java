package io.wojtech.Configuration.Parameter;


import javax.persistence.*;

/**
 * Created by user on 2017-08-12.
 */
@Entity
public class Parameter {
    public Parameter(long parameterId) {
        ParameterId = parameterId;
    }

    public Parameter(String name, String path, String type, int configurationTypeID, String value) {
        Name = name;
        Path = path;
        Type = type;
        this.configurationTypeId = configurationTypeID;
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

    @Column(name="ConfigurationTypeId")
    private int configurationTypeId;
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
        return configurationTypeId;
    }

    public void setConfigurationTypeID(int configurationTypeID) { this.configurationTypeId = configurationTypeID;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
