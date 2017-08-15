package io.wojtech.Configuration.ConfigurationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017-08-15.
 */
@Service
public class ConfigurationTypeService {
    @Autowired
    ConfigurationTypeRepository configurationTypeRepository;

    void addConfigurationType( ConfigurationType configurationType)
    {
        configurationTypeRepository.save(configurationType);
    }

    void updateConfigurationType( ConfigurationType configurationType)
    {
        configurationTypeRepository.save(configurationType);
    }

    void deleteConfigurationType( long configurationTypeId)
    {
        configurationTypeRepository.delete(configurationTypeId);
    }

    List<ConfigurationType> getAllConfigurationTypes()
    {
        return configurationTypeRepository.findAll();
    }


}
