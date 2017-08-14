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
    TemplateRestrictionRepository templateRestrictionRepository;

    @RequestMapping( method = RequestMethod.POST, value = "/templaterestriction")
    public void addRestriction( @RequestBody TemplateRestriction templateRestriction)
    {
        templateRestrictionRepository.save( templateRestriction );
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/templaterestriction/{templateId}/{restrictedTemplateId}")
    public void deleteRestriction( @PathVariable long templateId, @PathVariable long restrictedTemplateId )
    {
        TemplateRestriction.TemplateRestrictionId templateRestrictionId = new TemplateRestriction.TemplateRestrictionId(templateId,restrictedTemplateId);

        templateRestrictionRepository.delete(templateRestrictionId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templaterestriction")
    public List<TemplateRestriction> getAllRestrictions()
    {
        return templateRestrictionRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/templaterestriction/{templateId}")
    public List<TemplateRestriction> getRestrictionsForTemplate(@PathVariable long templateId)
    {
        List<TemplateRestriction> listOfRestrictionsForTemplate = new ArrayList<TemplateRestriction>();
        listOfRestrictionsForTemplate.addAll(templateRestrictionRepository.findAll().stream()
                .filter(restriction -> restriction.getTemplateId() == templateId )
                .collect(Collectors.toList()));

        return listOfRestrictionsForTemplate;

        //return templateRestrictionRepository.findByTemplateId(templateId);
    }

}
