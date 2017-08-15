package io.wojtech.Configuration.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class TemplateService {
    @Autowired
    TemplateRepository templateRepository;

    void addTemplate(Template template)
    {
        templateRepository.save(template);
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

}
