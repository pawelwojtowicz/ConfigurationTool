package io.wojtech.Configuration.Template;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class TemplateController {
    @Autowired
    TemplateRepository templateRepository;

    @RequestMapping( method = RequestMethod.POST , value = "/template")
    void addTemplate(@RequestBody Template template)
    {
        templateRepository.save(template);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/template")
    void updateTemplate(@RequestBody Template template)
    {
        templateRepository.save(template);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/template/{templateId}")
    void deleteTemplate(@PathVariable long templateId )
    {
        templateRepository.delete(templateId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/template")
    List<Template> getAllTemplates()
    {
        return templateRepository.findAll();
    }

}
