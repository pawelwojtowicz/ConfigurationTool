package io.wojtech.Configuration.TemplateParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class TemplateParameterService {

    @Autowired
    TemplateParameterRepository templateParameterRepository;

    public void addTemplateParameter( TemplateParameter templateParameter)
    {
        templateParameterRepository.save(templateParameter);
    }

    public void updateTemplateParameter( TemplateParameter templateParameter )
    {
        templateParameterRepository.save(templateParameter);
    }

    public void deleteTemplateParameter( long templateParameterId)
    {
        templateParameterRepository.delete(templateParameterId);
    }

    public List<TemplateParameter> getAllTemplateParameters()
    {
        return templateParameterRepository.findAll();
    }

    public List<TemplateParameter> getParametersForTemplate( long templateId)
    {
        return templateParameterRepository.findByTemplateId(templateId);
    }
}
