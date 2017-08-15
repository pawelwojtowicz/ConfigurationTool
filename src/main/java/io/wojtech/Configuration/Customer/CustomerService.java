package io.wojtech.Configuration.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017-08-15.
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }

    public void updateCustomer( Customer customer)
    {
        customerRepository.save(customer);
    }

    public void deleteCustomer( long customerId)
    {
        customerRepository.delete(customerId);
    }

    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
}
