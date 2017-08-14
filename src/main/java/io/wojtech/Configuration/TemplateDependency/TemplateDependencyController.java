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
    TemplateDependencyRepository templateDependencyRepository;

    @RequestMapping( method = RequestMethod.POST, value = "/templatedependency")
    public void addDependency( @RequestBody TemplateDependency templateDependency)
    {
        templateDependencyRepository.save( templateDependency );
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/templatedependency/{templateId}/{requiredTemplateId}")
    public void deleteDependency(@PathVariable long templateId, @PathVariable long requiredTemplateId )
    {
        TemplateDependency.TemplateDependencyId templateDependencyId = new TemplateDependency.TemplateDependencyId(templateId,requiredTemplateId);

        templateDependencyRepository.delete(templateDependencyId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templatedependency")
    public List<TemplateDependency> getAllDependencies()
    {
        return templateDependencyRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templatedependency/{templateId}")
    public List<TemplateDependency> getDependenciesForTemplate(@PathVariable long templateId)
    {
        List<TemplateDependency> listOfDependenciesForTemplate= new ArrayList<TemplateDependency>();
        listOfDependenciesForTemplate.addAll(templateDependencyRepository.findAll().stream()
                .filter(dependency-> dependency.getTemplateId() == templateId )
                .collect(Collectors.toList()));

        return listOfDependenciesForTemplate;
    }

}
