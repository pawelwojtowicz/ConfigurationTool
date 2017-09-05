package io.wojtech.Configuration.TemplateElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.wojtech.Configuration.Template.Template;
import io.wojtech.Configuration.Parameter.Parameter;
import io.wojtech.Configuration.TemplateParameter.TemplateParameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateElement {
    public TemplateElement() {
        templateElementID = new TemplateElementId(0, 0 );
        templateParameterId = 0;
    }
    public TemplateElement(long templateId, long parameterId, long templateParameterId) {
        templateElementID = new TemplateElementId(templateId, parameterId );
        templateParameterId = templateParameterId;
    }

    @Embeddable
    static public class TemplateElementId implements Serializable
    {
        public TemplateElementId() {
            this.templateId = 0;
            this.parameterId = 0;
        }

        public TemplateElementId(long templateId, long parameterId) {
            this.templateId = templateId;
            this.parameterId = parameterId;
        }

        public long getTemplateId() {
            return templateId;
        }

        public void setTemplateId(long templateId) {
            this.templateId = templateId;
        }

        public long getParameterId() {
            return parameterId;
        }

        public void setParameterId(long parameterId) {
            this.parameterId = parameterId;
        }

        @Column(name = "templateId", nullable = false)
        public long templateId;
        @Column(name = "parameterId", nullable = false)
        public long parameterId;
    }
    @EmbeddedId
    private TemplateElementId templateElementID;

    @Column(name = "templateParameterId")
    private long templateParameterId;

    @ManyToOne
    @JoinColumn( name = "templateParameterId", insertable = false, updatable = false)
    @JsonIgnoreProperties(value="parentTemplate")
    TemplateParameter templateParameter;

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
        return templateElementID.parameterId;
    }
    public void setParameterId(long parameterId) {
        templateElementID.parameterId = parameterId;
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

    public TemplateElementId getTemplateElementID() {
        return templateElementID;
    }

    public void setTemplateElementID(TemplateElementId templateElementID) {
        this.templateElementID = templateElementID;
    }

    public TemplateParameter getTemplateParameter() {
        return templateParameter;
    }

    public void setTemplateParameter(TemplateParameter templateParameter) {
        this.templateParameter = templateParameter;
    }
}
