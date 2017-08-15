package io.wojtech.Configuration.CustomerContext.Baseline;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-15.
 */
@Service
public class BaselineService {
    @Autowired
    BaselineRepository baselineRepository;

    void addBaseline(Baseline baseline)
    {
        baselineRepository.save(baseline);
    }

    void updateBaseline(Baseline baseline)
    {
        baselineRepository.save(baseline);
    }

    void deleteBaseline( long baselineId)
    {
        baselineRepository.delete(baselineId);
    }

    public List<Baseline> getAllBaselines()
    {
        return baselineRepository.findAll();
    }

    public List<Baseline> getBaselinesForCustomer( long customerId)
    {
        List<Baseline> customerBaselines = new ArrayList<Baseline>();

        customerBaselines.addAll(baselineRepository.findAll().stream()
                .filter(baseline-> baseline.getCustomerId() == customerId )
                .collect(Collectors.toList()));

        return customerBaselines;
    }
}
