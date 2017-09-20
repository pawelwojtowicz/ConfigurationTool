package io.wojtech.Configuration.TemplateRestriction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
public interface TemplateRestrictionRepository extends JpaRepository<TemplateRestriction,TemplateRestriction.TemplateRestrictionId> {
    List<TemplateRestriction> findByTemplateRestrictionIdTemplateId( long templateId );

    long deleteByTemplateRestrictionIdTemplateId( long templateId );
}
