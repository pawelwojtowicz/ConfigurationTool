package io.wojtech.Configuration.CustomerContext.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@RestController
public class ConfigurationController {
    @Autowired
    private ConfigurationRepository configurationRepository;

    @RequestMapping( method = RequestMethod.POST , value = "/configuration")
    public void addConfiguration(@RequestBody Configuration configuration)
    {
        configurationRepository.save(configuration);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/configuration")
    public void updateConfiguration(@RequestBody Configuration configuration)
    {
        configurationRepository.save(configuration);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/configuration/{configurationId}")
    public void deleteConfiguration(@PathVariable long configurationId)
    {
        configurationRepository.delete(configurationId);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configuration")
    public List<Configuration> getAllConfigurations()
    {
        return configurationRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.GET , value = "/configuration/{customerId}")
    public List<Configuration> getConfigurationsForCustomer( @PathVariable long customerId )
    {
        List<Configuration> configurationsForCustomer = new ArrayList<Configuration>();

        configurationsForCustomer.addAll(configurationRepository.findAll().stream()
                .filter(configuration-> configuration.getCustomerId() == customerId )
                .collect(Collectors.toList()));

        return configurationsForCustomer;
    }
}
