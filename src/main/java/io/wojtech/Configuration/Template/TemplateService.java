package io.wojtech.Configuration.Template;

import io.wojtech.Configuration.CustomerContext.ConfigurationElement.ConfigurationElementService;
import io.wojtech.Configuration.TemplateDependency.TemplateDependency;
import io.wojtech.Configuration.TemplateDependency.TemplateDependencyService;
import io.wojtech.Configuration.TemplateElement.TemplateElementService;
import io.wojtech.Configuration.TemplateParameter.TemplateParameter;
import io.wojtech.Configuration.TemplateParameter.TemplateParameterRepository;
import io.wojtech.Configuration.TemplateParameter.TemplateParameterService;
import io.wojtech.Configuration.TemplateRestriction.TemplateRestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class TemplateService {
    @Autowired
    TemplateRepository templateRepository;

    @Autowired
    TemplateElementService templateElementService;

    @Autowired
    TemplateDependencyService templateDependencyService;

    @Autowired
    TemplateRestrictionService templateRestrictionService;

    @Autowired
    TemplateParameterService templateParameterService;

    void addTemplate(Template template)
    {
        Set<TemplateParameter> templateParametersSet = template.getTemplateParameters();
        template.setTemplateParameters(null);
        Template savedTemplate = templateRepository.save(template);

        for ( TemplateParameter templateParameter : templateParametersSet) {
            templateParameter.setTemplateId(savedTemplate.getTemplateId());
            templateParameterService.addTemplateParameter(templateParameter);

        };
    }

    void updateTemplate(Template template)
    {
        templateRepository.save(template);
    }

    @Transactional
    void deleteTemplate(long templateId )
    {
        templateDependencyService.deleteTemplateDependencies(templateId);
        templateRestrictionService.deleteRestrictionsForTemplate(templateId);
        templateElementService.deleteTemplateElements(templateId);
        templateParameterService.deleteTemplateParameters(templateId);
        templateRepository.delete(templateId);
    }

    List<Template> getAllTemplates()
    {
        return templateRepository.findAll();
    }

    Template getTemplateById( long templateId ){
        return templateRepository.findByTemplateId(templateId);
    }

}
