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
        name = "";
        value = "";
        description = "";
        ownerId = "";
        parameterType = 0;
    }

    public TemplateParameter(long templateParameterId, long templateId, String name, String value, String description ,String ownerId, int parameterType) {
        this.templateParameterId = templateParameterId;
        this.templateId = templateId;
        this.name = name;
        this.value = value;
        this.description = description;
        this.ownerId = ownerId;
        this.parameterType = parameterType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public long getTemplateParameterId() {
        return templateParameterId;
    }

    public void setTemplateParameterId(long templateParameterId) {
        this.templateParameterId = templateParameterId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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

    public int getParameterType() {
        return parameterType;
    }

    public void setParameterType(int parameterType) {
        this.parameterType = parameterType;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long templateParameterId;

    private String name;
    private String value;
    private String description;
    private String ownerId;
    private long templateId;
    private int parameterType;

    @ManyToOne( )
    @JoinColumn( name = "templateId",  insertable = false, updatable = false)
    private Template parentTemplate;

    @JsonIgnore
    @OneToMany(mappedBy = "templateParameter", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    Set<TemplateElement> templateElements;

}
