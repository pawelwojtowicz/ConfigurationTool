package io.wojtech.Configuration.CustomerContext.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ConfigurationId;
    private long BaselineNumber;
    private String Name;
    private String Description;
    private long CustomerId;
}
