package io.wojtech.Configuration.TemplateParameter;

import javax.persistence.*;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateParameter {
    public TemplateParameter(long templateParameterId, long templateId, String name, String value, String description ,String ownerId) {
        TemplateParameterId = templateParameterId;
        this.templateId = templateId;
        Name = name;
        Value = value;
        Description = description;
        OwnerId = ownerId;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        templateId = templateId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public long getTemplateParameterId() {
        return TemplateParameterId;
    }

    public void setTemplateParameterId(long templateParameterId) {
        TemplateParameterId = templateParameterId;
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

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public int getMandatory() {
        return Mandatory;
    }

    public void setMandatory(int mandatory) {
        Mandatory = mandatory;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long TemplateParameterId;
    @Column( name = "TemplateId" )
    private long templateId;
    private String Name;
    private String Value;
    private String Description;
    private String OwnerId;
    private int Mandatory;
}
