package io.wojtech.Configuration.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-12.
 */
@RestController
public class ParameterController {

    @Autowired
    ParameterService parameterService;

    @RequestMapping( method = RequestMethod.POST , value = "/parameter")
    public void addParameter( @RequestBody Parameter parameter)
    {
        parameterService.addParameter(parameter);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/parameter")
    public void updateParameter( @RequestBody Parameter parameter)
    {
        parameterService.updateParameter(parameter);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/parameter/{parameterId}")
    public void deleteParameter( @PathVariable long parameterId)
    {
        parameterService.deleteParameter(parameterId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/parameter/{configurationTypeId}")
    public List<Parameter> getParametersForConfigType(@PathVariable long configurationTypeId)
    {
        return parameterService.getParametersForConfigType(configurationTypeId);
    }
}
