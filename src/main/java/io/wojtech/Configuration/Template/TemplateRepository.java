package io.wojtech.Configuration.Template;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-08-14.
 */
public interface TemplateRepository extends JpaRepository<Template,Long> {
    Template findByTemplateId( long templateId);
}
