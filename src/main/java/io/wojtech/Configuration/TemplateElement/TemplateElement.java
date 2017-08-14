package io.wojtech.Configuration.TemplateElement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateElement {

    @Embeddable
    public class TemplateElementId implements Serializable
    {
        @Column(name = "TemplateId", nullable = false)
        public long TemplateId;
        @Column(name = "ParameterId", nullable = false)
        public long ParameterId;
    }
    @EmbeddedId
    private TemplateElementId templateElementID;

    @Column(name = "TemplateParameterName")
    private long TemplateParameterName;

    public long getTemplateParameterName() {
        return TemplateParameterName;
    }
    public void setTemplateParameterName(long templateParameterName) {
        TemplateParameterName = templateParameterName;
    }
    public long getTemplateId() {
        return templateElementID.TemplateId;
    }
    public void setTemplateId(long templateId) {
        templateElementID.TemplateId = templateId;
    }
    public long getParameterId() {
        return templateElementID.ParameterId;
    }
    public void setParameterId(long parameterId) {
        templateElementID.ParameterId = parameterId;
    }
}
