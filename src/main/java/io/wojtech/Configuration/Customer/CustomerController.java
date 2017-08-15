package io.wojtech.Configuration.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-15.
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping( method = RequestMethod.POST , value = "/customer" )
    public void addCustomer(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/customer" )
    public void updateCustomer(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
    }

    @RequestMapping( method = RequestMethod.DELETE , value = "/customer/{customerId}")
    public void deleteCustomer( @PathVariable long customerId)
    {
        customerRepository.delete(customerId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/customer")
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
}
