package io.wojtech.Configuration.TemplateRestriction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class TemplateRestrictionService {
    @Autowired
    TemplateRestrictionRepository templateRestrictionRepository;

    public void addRestriction( TemplateRestriction templateRestriction)
    {

        templateRestrictionRepository.save( templateRestriction );
    }

    public void deleteRestriction( long templateId, long restrictedTemplateId )
    {
        TemplateRestriction.TemplateRestrictionId templateRestrictionId = new TemplateRestriction.TemplateRestrictionId(templateId,restrictedTemplateId);

        templateRestrictionRepository.delete(templateRestrictionId);
    }

    public List<TemplateRestriction> getAllRestrictions()
    {
        return templateRestrictionRepository.findAll();

    }

    public List<TemplateRestriction> getRestrictionsForTemplate( long templateId)
    {
        List<TemplateRestriction> listOfRestrictionsForTemplate = new ArrayList<TemplateRestriction>();
        listOfRestrictionsForTemplate.addAll(templateRestrictionRepository.findAll().stream()
                .filter(restriction -> restriction.getTemplateId() == templateId )
                .collect(Collectors.toList()));

        return listOfRestrictionsForTemplate;
    }

}
