package io.wojtech.Configuration.TemplateElement;

import io.wojtech.Configuration.Parameter.Parameter;
import io.wojtech.Configuration.Parameter.ParameterRepository;
import io.wojtech.Configuration.TemplateParameter.TemplateParameter;
import io.wojtech.Configuration.TemplateParameter.TemplateParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class TemplateElementService {

    @Autowired
    TemplateElementRepository templateElementRepository;

    @Autowired
    TemplateParameterRepository templateParameterRepository;

    @Autowired
    ParameterRepository parameterRepository;

    void addTemplateElement( TemplateElement templateElement)
    {
        TemplateParameter elementValue = templateParameterRepository.findOne(templateElement.getTemplateParameterId());
        Parameter parameter = parameterRepository.findByParameterId(templateElement.getParameterId());

        templateElement.setParameter(parameter);
        templateElement.setTemplateParameter(elementValue);

        templateElementRepository.save(templateElement);
    }

    void updateTemplateElement( TemplateElement templateElement)
    {
        templateElementRepository.save(templateElement);
    }

    void deleteTemplateElement( long templateId, long parameterId )
    {
        List<TemplateElement> elements = templateElementRepository.findAll();

        TemplateElement.TemplateElementId templateElementId = new TemplateElement.TemplateElementId(templateId,parameterId);
        templateElementRepository.delete(templateElementId);
    }

    List<TemplateElement> getAllTemplateElements()
    {
        return templateElementRepository.findAll();
    }

    List<TemplateElement> getElementsOfTemplate( long templateId)
    {
        List<TemplateElement> listOfTemplateElements = new ArrayList<TemplateElement>();
        listOfTemplateElements.addAll(templateElementRepository.findAll().stream()
                .filter(templateElement -> templateElement.getTemplateId() == templateId )
                .collect(Collectors.toList()));

        return listOfTemplateElements;
    }
}
