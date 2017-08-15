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
    private CustomerService customerService;

    @RequestMapping( method = RequestMethod.POST , value = "/customer" )
    public void addCustomer(@RequestBody Customer customer)
    {
        customerService.addCustomer(customer);
    }

    @RequestMapping( method = RequestMethod.PUT , value = "/customer" )
    public void updateCustomer(@RequestBody Customer customer)
    {
        customerService.updateCustomer(customer);
    }

    @RequestMapping( method = RequestMethod.DELETE , value = "/customer/{customerId}")
    public void deleteCustomer( @PathVariable long customerId)
    {
        customerService.deleteCustomer(customerId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/customer")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }
}
