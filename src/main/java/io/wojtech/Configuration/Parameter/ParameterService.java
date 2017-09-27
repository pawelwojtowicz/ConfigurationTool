package io.wojtech.Configuration.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-12.
 */
@Service
public class ParameterService {

    @Autowired
    ParameterRepository parameterRepository;

    public void addParameter( Parameter parameter)
    {
        String parametersPath = parameter.getPath();

        parameter.setGenericPath( ParameterToolbox.isGenericPath(parametersPath)? 1 : 0);

        parameterRepository.save(parameter);
    }

    public List<Parameter> getAllParameters() {
        return parameterRepository.findAll();
    }

    public Parameter getParameterById( long parameterId ) {
        return parameterRepository.findByParameterId(parameterId);
    }

    public void updateParameter( Parameter parameter)
    {
        parameterRepository.save(parameter);
    }

    public void deleteParameter( long parameterId)
    {
        parameterRepository.delete(parameterId);
    }
}
