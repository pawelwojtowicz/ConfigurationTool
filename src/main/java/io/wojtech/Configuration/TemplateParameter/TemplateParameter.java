package io.wojtech.Configuration.TemplateParameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateParameter {
    public TemplateParameter(long templateId, String name, String value, String ownerId) {
        TemplateId = templateId;
        Name = name;
        Value = value;
        OwnerId = ownerId;
    }

    public long getTemplateId() {
        return TemplateId;
    }

    public void setTemplateId(long templateId) {
        TemplateId = templateId;
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

    public void setValue(String value) {
        Value = value;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    @Id
    private long TemplateId;
    private String Name;
    private String Value;
    private String OwnerId;
}
