package io.wojtech.Configuration.TemplateElement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateElement {
    public TemplateElement(long templateId, long parameterId, long templateParameterId) {
        templateElementID = new TemplateElementId(templateId, parameterId );
        TemplateParameterId = templateParameterId;
    }

    @Embeddable
    static public class TemplateElementId implements Serializable
    {
        public TemplateElementId(long templateId, long parameterId) {
            templateId = templateId;
            ParameterId = parameterId;
        }

        @Column(name = "TemplateId", nullable = false)
        public long templateId;
        @Column(name = "ParameterId", nullable = false)
        public long ParameterId;
    }
    @EmbeddedId
    private TemplateElementId templateElementID;

    @Column(name = "TemplateParameterId")
    private long TemplateParameterId;

    public long getTemplateParameterId() {
        return TemplateParameterId;
    }
    public void setTemplateParameterId(long templateParameterName) {
        TemplateParameterId = templateParameterName;
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
}
