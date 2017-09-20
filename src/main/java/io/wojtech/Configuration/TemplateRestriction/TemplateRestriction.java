package io.wojtech.Configuration.TemplateRestriction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateRestriction {
    @Embeddable
    static public class TemplateRestrictionId implements Serializable
    {
        public TemplateRestrictionId() {
            templateId = 0;
            RestrictedTemplateId = 0;
        }

        public TemplateRestrictionId(long templateId, long restrictedTemplateId) {
            this.templateId = templateId;
            RestrictedTemplateId = restrictedTemplateId;
        }

        @Column(name = "templateId", nullable = false)
        public long templateId;

        @Column(name = "restrictedTemplateId", nullable = false)
        public long RestrictedTemplateId;

    }

    @EmbeddedId
    private TemplateRestrictionId templateRestrictionId;

    public TemplateRestriction() {
        this.templateRestrictionId = new TemplateRestrictionId(0,0);
    }
    public TemplateRestriction(long templateId, long longRestrictedTemplateId) {
        this.templateRestrictionId = new TemplateRestrictionId(templateId, longRestrictedTemplateId);
    }
    public long getTemplateId() {
        return templateRestrictionId.templateId;
    }
    public void setTemplateId(long templateId) {
        templateRestrictionId.templateId = templateId;
    }
    public long getRestrictedTemplateId() {
        return templateRestrictionId.RestrictedTemplateId;
    }
    public void setRestrictedTemplateId(long restrictedTemplateId) {
        templateRestrictionId.RestrictedTemplateId = restrictedTemplateId;
    }
}
