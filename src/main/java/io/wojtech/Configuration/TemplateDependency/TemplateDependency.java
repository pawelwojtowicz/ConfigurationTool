package io.wojtech.Configuration.TemplateDependency;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateDependency {

    @Embeddable
    static public class TemplateDependencyId implements Serializable
    {
        public TemplateDependencyId(long templateId, long requiredTemplateId) {
            TemplateId = templateId;
            RequiredTemplateId = requiredTemplateId;
        }

        public long getTemplateId() {
            return TemplateId;
        }

        public void setTemplateId(long templateId) {
            TemplateId = templateId;
        }

        public long getRequiredTemplateId() {
            return RequiredTemplateId;
        }

        public void setRequiredTemplateId(long requiredTemplateId) {
            RequiredTemplateId = requiredTemplateId;
        }

        @Column(name = "TemplateId", nullable = false)
        public long TemplateId;

        @Column(name = "RequiredTemplateId", nullable = false)
        public long RequiredTemplateId;

    }

    @EmbeddedId
    private TemplateDependencyId templateDependencyId;

    public TemplateDependency()
    {
        templateDependencyId = new TemplateDependencyId(0,0);
    }

    public TemplateDependency(long templateId, long requiredTemplateId)
    {
        templateDependencyId = new TemplateDependencyId(templateId, requiredTemplateId);
    }

    public long getTemplateId() {
        return templateDependencyId.TemplateId;
    }

    public void setTemplateId(long templateId) {
        templateDependencyId.TemplateId = templateId;
    }

    public long getRequiredTemplateId() {
        return templateDependencyId.RequiredTemplateId;
    }

    public void setRequiredTemplateId(long requiredTemplateId) {
        templateDependencyId.RequiredTemplateId = requiredTemplateId;
    }

}
