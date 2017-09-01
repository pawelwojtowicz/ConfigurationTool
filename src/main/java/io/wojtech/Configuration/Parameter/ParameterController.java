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

    @RequestMapping( method = RequestMethod.POST , value = "/parameters")
    public void addParameter( @RequestBody Parameter parameter)
    {
        parameterService.addParameter(parameter);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/parameters")
    public List<Parameter> getAllParameters()
    {
        return parameterService.getAllParameters();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/parameters/{parameterId}")
    public Parameter getAllParameters(@PathVariable long parameterId)
    {
        return parameterService.getParameterById(parameterId);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/parameters")
    public void updateParameter( @RequestBody Parameter parameter)
    {
        parameterService.updateParameter(parameter);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/parameters/{parameterId}")
    public void deleteParameter( @PathVariable long parameterId)
    {
        parameterService.deleteParameter(parameterId);
    }
}
