package io.wojtech.Configuration.TemplateElement;

import io.wojtech.Configuration.Template.Template;
import io.wojtech.Configuration.Parameter.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateElement {
    public TemplateElement(long templateId, long parameterId, long templateParameterId) {
        templateElementID = new TemplateElementId(templateId, parameterId );
        templateParameterId = templateParameterId;
    }

    @Embeddable
    static public class TemplateElementId implements Serializable
    {
        public TemplateElementId(long templateId, long parameterId) {
            templateId = templateId;
            ParameterId = parameterId;
        }

        @Column(name = "templateId", nullable = false)
        public long templateId;
        @Column(name = "parameterId", nullable = false)
        public long ParameterId;
    }
    @EmbeddedId
    private TemplateElementId templateElementID;

    @Column(name = "templateParameterId")
    private long templateParameterId;

    @ManyToOne()
    @JoinColumn( name = "templateId",  insertable = false, updatable = false)
    Template parentTemplate;

    @OneToOne
    @JoinColumn( name = "parameterId", insertable = false, updatable = false)
    Parameter parameter;


    public long getTemplateParameterId() {
        return templateParameterId;
    }
    public void setTemplateParameterId(long templateParameterName) {
        templateParameterId = templateParameterName;
    }
    public long getTemplateId() {
        return templateElementID.templateId;
    }
    public void setTemplateId(long templateId) {
        templateElementID.templateId = templateId;
    }
    public long getParameterId() {
        return templateElementID.ParameterId;
    }
    public void setParameterId(long parameterId) {
        templateElementID.ParameterId = parameterId;
    }

    public Template getParentTemplate() {
        return parentTemplate;
    }

    public void setParentTemplate(Template parentTemplate) {
        this.parentTemplate = parentTemplate;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}
