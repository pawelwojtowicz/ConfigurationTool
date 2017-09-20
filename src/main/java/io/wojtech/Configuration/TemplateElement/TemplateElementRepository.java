package io.wojtech.Configuration.TemplateElement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
public interface TemplateElementRepository extends JpaRepository<TemplateElement, TemplateElement.TemplateElementId> {
	
	List<TemplateElement> findByTemplateElementIdTemplateId(long templateId);

}
