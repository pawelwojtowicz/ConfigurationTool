package io.wojtech.Configuration.TemplateDependency;

import io.wojtech.Configuration.Template.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
public interface TemplateDependencyRepository extends JpaRepository<TemplateDependency,TemplateDependency.TemplateDependencyId> {
    List<TemplateDependency> findByTemplateDependencyIdTemplateId(long templateId);
    long deleteByTemplateDependencyIdTemplateId(long templateId);

}
