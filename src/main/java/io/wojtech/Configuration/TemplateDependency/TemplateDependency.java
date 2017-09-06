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
        public TemplateDependencyId() {
            this.templateId = 0;
            this.requiredTemplateId = 0;
        }

        public TemplateDependencyId(long templateId, long requiredTemplateId) {
            this.templateId = templateId;
            this.requiredTemplateId = requiredTemplateId;
        }

        public long getTemplateId() {
            return templateId;
        }

        public void setTemplateId(long templateId) {
            templateId = templateId;
        }

        public long getRequiredTemplateId() {
            return requiredTemplateId;
        }

        public void setRequiredTemplateId(long requiredTemplateId) {
            requiredTemplateId = requiredTemplateId;
        }

        @Column(name = "templateId", nullable = false)
        public long templateId;

        @Column(name = "requiredTemplateId", nullable = false)
        public long requiredTemplateId;

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
        return templateDependencyId.templateId;
    }

    public void setTemplateId(long templateId) {
        templateDependencyId.templateId = templateId;
    }

    public long getRequiredTemplateId() {
        return templateDependencyId.requiredTemplateId;
    }

    public void setRequiredTemplateId(long requiredTemplateId) {
        templateDependencyId.requiredTemplateId = requiredTemplateId;
    }

}
