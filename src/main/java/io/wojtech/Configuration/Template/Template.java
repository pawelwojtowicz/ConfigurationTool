package io.wojtech.Configuration.Template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.wojtech.Configuration.TemplateElement.TemplateElement;
import io.wojtech.Configuration.TemplateParameter.TemplateParameter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long templateId;
    private String name;
    private String description;
    private long ownerId;
    private int templateStatus;
    private int licensed;

    @OneToMany(mappedBy = "parentTemplate", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="parentTemplate")
    Set<TemplateParameter> templateParameters;

    @OneToMany(mappedBy = "parentTemplate", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="parentTemplate")
    Set<TemplateElement> templateElements;

    public Template() {
        this.templateId = 0;
        this.name = "";
        this.description = "";
        this.ownerId = 0;
        this.templateStatus = 0;
        this.licensed = 0;
        this.templateParameters = null;
        this.templateElements = null;
    }

    public Template(long templateId, String name, String description, long ownerId, int templateStatus, int licensed, Set<TemplateParameter> templateParameters, Set<TemplateElement> templateElements) {
        this.templateId = templateId;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
        this.templateStatus = templateStatus;
        this.licensed = licensed;
        this.templateParameters = templateParameters;
        this.templateElements = templateElements;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public int getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(int templateStatus) {
        this.templateStatus = templateStatus;
    }

    public int getLicensed() {
        return licensed;
    }

    public void setLicensed(int licensed) {
        this.licensed = licensed;
    }

    public Set<TemplateParameter> getTemplateParameters() {
        return templateParameters;
    }

    public void setTemplateParameters(Set<TemplateParameter> templateParameters) {
        this.templateParameters = templateParameters;
    }

    public Set<TemplateElement> getTemplateElements() {
        return templateElements;
    }

    public void setTemplateElements(Set<TemplateElement> templateElements) {
        this.templateElements = templateElements;
    }
}
