package io.wojtech.Configuration.TemplateElement;

import io.wojtech.Configuration.TemplateRestriction.TemplateRestriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class TemplateElementController {

    @Autowired
    TemplateElementRepository templateElementRepository;

    @RequestMapping( method = RequestMethod.POST, value = "/templateelement")
    void addTemplateElement( @RequestBody TemplateElement templateElement)
    {
        templateElementRepository.save(templateElement);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/templateelement")
    void updateTemplateElement( @RequestBody TemplateElement templateElement)
    {
        templateElementRepository.save(templateElement);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "templateelement/{templateElementId}")
    void deleteTemplateElement( @PathVariable long templateId, @PathVariable long parameterId )
    {
        TemplateElement.TemplateElementId templateElementId = new TemplateElement.TemplateElementId(templateId,parameterId);
        templateElementRepository.delete(templateElementId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templatelement")
    List<TemplateElement> getAllTemplateElements()
    {
        return templateElementRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET , value = "/templateelement/{templateId}")
    List<TemplateElement> getElementsOfTemplate( @PathVariable long templateId)
    {
        List<TemplateElement> listOfTemplateElements = new ArrayList<TemplateElement>();
        listOfTemplateElements.addAll(templateElementRepository.findAll().stream()
                .filter(templateElement -> templateElement.getTemplateId() == templateId )
                .collect(Collectors.toList()));

        return listOfTemplateElements;
    }
}
