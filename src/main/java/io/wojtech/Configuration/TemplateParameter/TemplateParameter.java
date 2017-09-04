package io.wojtech.Configuration.TemplateParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.wojtech.Configuration.Template.Template;
import io.wojtech.Configuration.TemplateElement.TemplateElement;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateParameter {
    public TemplateParameter() {
        this.templateParameterId = 0;
        this.templateId = 0;
        Name = "";
        Value = "";
        Description = "";
        OwnerId = "";
    }

    public TemplateParameter(long templateParameterId, long templateId, String name, String value, String description ,String ownerId) {
        this.templateParameterId = templateParameterId;
        this.templateId = templateId;
        Name = name;
        Value = value;
        Description = description;
        OwnerId = ownerId;
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
        return templateParameterId;
    }

    public void setTemplateParameterId(long templateParameterId) {
        this.templateParameterId = templateParameterId;
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

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public Template getParentTemplate() {
        return parentTemplate;
    }

    public void setParentTemplate(Template parentTemplate) {
        this.parentTemplate = parentTemplate;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long templateParameterId;

    private String Name;
    private String Value;
    private String Description;
    private String OwnerId;
    private long templateId;

    @ManyToOne( )
    @JoinColumn( name = "templateId",  insertable = false, updatable = false)
    private Template parentTemplate;

    @JsonIgnore
    @OneToMany(mappedBy = "templateParameter", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    Set<TemplateElement> templateElements;

}
