package io.wojtech.Configuration.ConfigurationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class ConfigurationType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ConfigurationTypeId;
    private String Name;
    private String Description;
}
