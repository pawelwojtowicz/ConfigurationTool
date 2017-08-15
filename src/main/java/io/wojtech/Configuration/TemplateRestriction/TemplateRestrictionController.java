package io.wojtech.Configuration.TemplateRestriction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class TemplateRestrictionController {
    @Autowired
    TemplateRestrictionService templateRestrictionRepository;

    @RequestMapping( method = RequestMethod.POST, value = "/templaterestriction")
    public void addRestriction( @RequestBody TemplateRestriction templateRestriction)
    {
        templateRestrictionRepository.addRestriction(templateRestriction );
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/templaterestriction/{templateId}/{restrictedTemplateId}")
    public void deleteRestriction( @PathVariable long templateId, @PathVariable long restrictedTemplateId )
    {
        templateRestrictionRepository.deleteRestriction(templateId,restrictedTemplateId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templaterestriction")
    public List<TemplateRestriction> getAllRestrictions()
    {
        return templateRestrictionRepository.getAllRestrictions();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templaterestriction/{templateId}")
    public List<TemplateRestriction> getRestrictionsForTemplate(@PathVariable long templateId)
    {
        return templateRestrictionRepository.getRestrictionsForTemplate(templateId);
    }

}
