package io.wojtech.Configuration.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-08-14.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
