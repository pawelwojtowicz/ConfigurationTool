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
    TemplateParameterService templateParameterService;

    @RequestMapping( method = RequestMethod.POST , value = "/templateparameter")
    public void addTemplateParameter( @RequestBody TemplateParameter templateParameter)
    {
        templateParameterService.addTemplateParameter(templateParameter);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/templateparameter")
    public void updateTemplateParameter( @RequestBody TemplateParameter templateParameter )
    {
        templateParameterService.updateTemplateParameter(templateParameter);
    }

    @RequestMapping( method = RequestMethod.DELETE , value = "/templateparameter/{templateParameterId}")
    public void deleteTemplateParameter(@PathVariable long templateParameterId)
    {
        templateParameterService.deleteTemplateParameter(templateParameterId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/templateparameter")
    public List<TemplateParameter> getAllTemplateParameters()
    {
        return templateParameterService.getAllTemplateParameters();
    }

    @RequestMapping (method = RequestMethod.GET, value = "/templateparameter/{templateId}")
    public List<TemplateParameter> getParametersForTemplate( @PathVariable long templateId)
    {
        return templateParameterService.getParametersForTemplate(templateId);
    }
}
