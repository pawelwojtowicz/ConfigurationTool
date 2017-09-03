package io.wojtech.Configuration.Template;

import io.wojtech.Configuration.TemplateParameter.TemplateParameter;
import io.wojtech.Configuration.TemplateParameter.TemplateParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    TemplateParameterRepository parametersRepository;

    void addTemplate(Template template)
    {
        Set<TemplateParameter> templateParametersSet = template.getTemplateParameters();
        template.setTemplateParameters(null);
        Template savedTemplate = templateRepository.save(template);

        for ( TemplateParameter templateParameter : templateParametersSet) {
            templateParameter.setTemplateId(savedTemplate.getTemplateId());
            parametersRepository.save(templateParameter);

        };


        List<TemplateParameter> parametersy = parametersRepository.findAll();

        int a =1;

    }

    void updateTemplate(Template template)
    {
        templateRepository.save(template);
    }

    void deleteTemplate(long templateId )
    {
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
