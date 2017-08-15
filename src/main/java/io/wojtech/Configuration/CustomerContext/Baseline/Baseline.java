package io.wojtech.Configuration.CustomerContext.Baseline;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by user on 2017-08-15.
 */
@Entity
public class Baseline {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private long BaselineId;
    private long CustomerId;
    private long BaselineNumber;
    private String Name;
    private String Description;
    private String Timestamp;
    private String User;


    public Baseline(long baselineId ,long customerId, long baselineNumber, String name, String description, String timestamp, String user) {
        BaselineId = baselineId;
        CustomerId = customerId;
        BaselineId = baselineNumber;
        Name = name;
        Description = description;
        Timestamp = timestamp;
        User = user;
    }

    public long getCustomerId()
    {
        return CustomerId;
    }

    public void setCustomerId(long customerId)
    {
        CustomerId = customerId;
    }

    public long getBaselineNumber()
    {
        return BaselineNumber;
    }

    public void setBaselineNumber( long baselineNumber )
    {
        BaselineNumber = baselineNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

}
