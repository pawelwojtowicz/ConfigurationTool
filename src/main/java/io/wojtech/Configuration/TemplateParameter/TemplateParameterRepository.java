package io.wojtech.Configuration.TemplateParameter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
public interface TemplateParameterRepository extends JpaRepository<TemplateParameter,Long> {

    List<TemplateParameter> findByTemplateId(long TemplateId);

    long deleteByTemplateId(long templateId);
}
