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
    TemplateService templateService;

    @RequestMapping( method = RequestMethod.POST , value = "/template")
    void addTemplate(@RequestBody Template template)
    {
        templateService.addTemplate(template);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/template")
    void updateTemplate(@RequestBody Template template)
    {
        templateService.updateTemplate(template);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/template/{templateId}")
    void deleteTemplate(@PathVariable long templateId )
    {
        templateService.deleteTemplate(templateId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/template")
    List<Template> getAllTemplates()
    {
        return templateService.getAllTemplates();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/template/{templateId}")
    Template getTemplateByIt( @PathVariable long templateId) {
        Template template = templateService.getTemplateById( templateId);
        return template;
    }

}
