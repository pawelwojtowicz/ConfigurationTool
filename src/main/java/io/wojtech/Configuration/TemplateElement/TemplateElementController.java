package io.wojtech.Configuration.TemplateElement;

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
    TemplateElementService templateElementService;

    @RequestMapping( method = RequestMethod.POST, value = "/templateelement")
    void addTemplateElement( @RequestBody TemplateElement templateElement)
    {
        templateElementService.addTemplateElement(templateElement);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/templateelement")
    void updateTemplateElement( @RequestBody TemplateElement templateElement)
    {
        templateElementService.updateTemplateElement(templateElement);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/templateelement/{templateId}/{parameterId}")
    void deleteTemplateElement( @PathVariable long templateId, @PathVariable long parameterId )
    {
        templateElementService.deleteTemplateElement(templateId,parameterId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templatelement")
    List<TemplateElement> getAllTemplateElements()
    {
        return templateElementService.getAllTemplateElements();
    }

    @RequestMapping(method = RequestMethod.GET , value = "/templateelement/{templateId}")
    List<TemplateElement> getElementsOfTemplate( @PathVariable long templateId)
    {
        return templateElementService.getElementsOfTemplate(templateId);
    }
}
