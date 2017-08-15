package io.wojtech.Configuration.TemplateDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class TemplateDependencyController {
    @Autowired
    TemplateDependencyService templateDependencyService;

    @RequestMapping( method = RequestMethod.POST, value = "/templatedependency")
    public void addDependency( @RequestBody TemplateDependency templateDependency)
    {
        templateDependencyService.addDependency( templateDependency );
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/templatedependency/{templateId}/{requiredTemplateId}")
    public void deleteDependency(@PathVariable long templateId, @PathVariable long requiredTemplateId )
    {
        templateDependencyService.deleteDependency(templateId, requiredTemplateId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templatedependency")
    public List<TemplateDependency> getAllDependencies()
    {
        return templateDependencyService.getAllDependencies();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templatedependency/{templateId}")
    public List<TemplateDependency> getDependenciesForTemplate(@PathVariable long templateId)
    {
        return templateDependencyService.getDependenciesForTemplate(templateId);
    }

}
