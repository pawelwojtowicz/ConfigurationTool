package io.wojtech.Configuration.TemplateParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class TemplateParameterController {

    @Autowired
    TemplateParameterRepository templateParameterRepository;

    @RequestMapping( method = RequestMethod.POST , value = "/templateparameter")
    public void addTemplateParameter( @RequestBody TemplateParameter templateParameter)
    {
        templateParameterRepository.save(templateParameter);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/templateparameter")
    public void updateTemplateParameter( @RequestBody TemplateParameter templateParameter )
    {
        templateParameterRepository.save(templateParameter);
    }

    @RequestMapping( method = RequestMethod.DELETE , value = "/templateparameter/{templateParameterId}")
    public void deleteTemplateParameter(@PathVariable long templateParameterId)
    {
        templateParameterRepository.delete(templateParameterId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/templateparameter")
    public List<TemplateParameter> getAllTemplateParameters()
    {
        return templateParameterRepository.findAll();
    }

    @RequestMapping (method = RequestMethod.GET, value = "/templateparameter/{templateId}")
    public List<TemplateParameter> getParametersForTemplate( @PathVariable long templateId)
    {
        return templateParameterRepository.findByTemplateId(templateId);
    }
}
