package io.wojtech.Configuration.CustomerContext.ConfigurationElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.wojtech.Configuration.CustomerContext.Configuration.Configuration;
import io.wojtech.Configuration.Template.Template;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */


@Entity
public class ConfigurationElement {

    @Id
    @Column( name = "configurationElementId", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long configurationElementId;

    @Column(name = "baselineId",nullable = false)
    public long baselineId;

    @Column(name = "parentConfigurationId")
    long parentConfigurationId;

    long templateId;

    String genericTemplatePath;

    @ManyToOne()
    @JoinColumn(name = "parentConfigurationId",  insertable = false, updatable = false)
    Configuration parentConfiguration;

    @ManyToOne()
    @JoinColumn( name = "templateId" , insertable = false, updatable = false)
    Template template;

    public ConfigurationElement() {
        this.configurationElementId = 0;
        this.baselineId = 0;
        this.parentConfigurationId = 0;
        this.templateId = 0;
        this.genericTemplatePath = "";
    }

    public ConfigurationElement(long configurationElementId, long baselineId, long configurationId, long templateId) {
        this.configurationElementId = configurationElementId;
        this.baselineId = baselineId;
        this.parentConfigurationId = configurationId;
        this.templateId = templateId;
        this.genericTemplatePath = "";
    }

    public long getConfigurationElementId() {
        return this.configurationElementId;
    }

    public void setConfigurationElementId(long configurationElementId) {
        this.configurationElementId = configurationElementId;
    }

    public long getBaselineId() {
        return this.baselineId;
    }

    public void setBaselineId(long baselineId) {
        this.baselineId = baselineId;
    }

    public long getParentConfigurationId() {
        return parentConfigurationId;
    }

    public void setParentConfigurationId(long configurationId) {
        this.parentConfigurationId= configurationId;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public String getGenericTemplatePath() {
        return genericTemplatePath;
    }

    public void setGenericTemplatePath(String genericTemplatePath) {
        this.genericTemplatePath = genericTemplatePath;
    }

    public Configuration getParentConfiguration() {
        return parentConfiguration;
    }

    public void setParentConfiguration(Configuration parentConfiguration) {
        this.parentConfiguration = parentConfiguration;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
