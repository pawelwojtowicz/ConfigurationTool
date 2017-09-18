package io.wojtech.Configuration.Template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.wojtech.Configuration.CustomerContext.ConfigurationElement.ConfigurationElement;
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
    @JsonIgnoreProperties(value={"parentTemplate","templateElements"})
    Set<TemplateParameter> templateParameters;

    @OneToMany(mappedBy = "parentTemplate", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="parentTemplate")
    Set<TemplateElement> templateElements;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable( name = "templateDependency",
            joinColumns = @JoinColumn(name = "templateId", referencedColumnName = "templateId"),
            inverseJoinColumns = @JoinColumn( name ="requiredTemplateId", referencedColumnName = "templateId"))
    @JsonIgnoreProperties(value="dependentTemplates")
    Set<Template> templateDependencies;

    @ManyToMany( mappedBy = "templateDependencies", fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Template> dependentTemplates;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable( name = "templateRestriction",
            joinColumns = @JoinColumn(name = "templateId", referencedColumnName = "templateId"),
            inverseJoinColumns = @JoinColumn( name ="restrictedTemplateId", referencedColumnName = "templateId"))
    @JsonIgnoreProperties(value="restrictedTemplates")
    Set<Template> templateRestrictions;

    @ManyToMany( mappedBy = "templateRestrictions", fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Template> restrictedTemplates;

    @OneToMany(mappedBy = "template", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value="template")
    @JsonIgnore
    Set<ConfigurationElement> configurationElements;



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

    public Set<Template> getTemplateDependencies() {
        return templateDependencies;
    }

    public void setTemplateDependencies(Set<Template> templateDependencies) {
        this.templateDependencies = templateDependencies;
    }

    public Set<Template> getDependentTemplates() {
        return dependentTemplates;
    }

    public void setDependentTemplates(Set<Template> dependentTemplates) {
        this.dependentTemplates = dependentTemplates;
    }

    public Set<Template> getTemplateRestrictions() {
        return templateRestrictions;
    }

    public void setTemplateRestrictions(Set<Template> templateRestrictions) {
        this.templateRestrictions = templateRestrictions;
    }

    public Set<Template> getRestrictedTemplates() {
        return restrictedTemplates;
    }

    public void setRestrictedTemplates(Set<Template> restrictedTemplates) {
        this.restrictedTemplates = restrictedTemplates;
    }

    public Set<ConfigurationElement> getConfigurationElements() {
        return configurationElements;
    }

    public void setConfigurationElements(Set<ConfigurationElement> configurationElements) {
        this.configurationElements = configurationElements;
    }
}
