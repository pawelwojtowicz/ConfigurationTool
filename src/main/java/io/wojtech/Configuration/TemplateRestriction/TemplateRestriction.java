package io.wojtech.Configuration.TemplateRestriction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class TemplateRestriction {
    @Embeddable
    public class TemplateRestrictionId implements Serializable
    {
        public TemplateRestrictionId(long templateId, long restrictedTemplateId) {
            TemplateId = templateId;
            RestrictedTemplateId = restrictedTemplateId;
        }

        @Column(name = "TemplateId", nullable = false)
        public long TemplateId;

        @Column(name = "RestrictedTemplateId", nullable = false)
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
        return templateRestrictionId.TemplateId;
    }
    public void setTemplateId(long templateId) {
        templateRestrictionId.TemplateId = templateId;
    }
    public long getRestrictedTemplateId() {
        return templateRestrictionId.RestrictedTemplateId;
    }
    public void setRestrictedTemplateId(long restrictedTemplateId) {
        templateRestrictionId.RestrictedTemplateId = restrictedTemplateId;
    }
}
