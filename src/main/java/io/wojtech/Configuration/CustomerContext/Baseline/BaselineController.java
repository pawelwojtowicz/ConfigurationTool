package io.wojtech.Configuration.CustomerContext.Baseline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@RestController
public class BaselineController {

    @Autowired
    private BaselineRepository baselineRepository;

    @RequestMapping( method = RequestMethod.POST , value = "/baseline")
    void addBaseline(@RequestBody Baseline baseline )
    {
        baselineRepository.save(baseline);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/baseline")
    void updateBaseline( @RequestBody Baseline baseline )
    {
        baselineRepository.save(baseline);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/baseline/{baselineId}")
    void deleteBaseline( @PathVariable long baselineId)
    {
        baselineRepository.delete(baselineId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/baseline")
    public List<Baseline> getAllBaselines()
    {
        return baselineRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.GET , value = "/baseline/{customerId}")
    public List<Baseline> getCustomerBaselines( @PathVariable long customerId)
    {
        List<Baseline> customerBaselines = new ArrayList<Baseline>();

        customerBaselines.addAll(baselineRepository.findAll().stream()
                .filter(baseline-> baseline.getCustomerId() == customerId )
                .collect(Collectors.toList()));

        return customerBaselines;
    }
}
