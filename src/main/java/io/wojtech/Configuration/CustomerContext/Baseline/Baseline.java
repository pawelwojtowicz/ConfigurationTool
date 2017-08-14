package io.wojtech.Configuration.CustomerContext.Baseline;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by user on 2017-08-15.
 */
@Entity
public class Baseline {

    @Embeddable
    static public class BaselineId implements Serializable
    {
        public BaselineId(long customerId, long baselineNumber) {
            CustomerId = customerId;
            BaselineNumber = baselineNumber;
        }

        @Column( name = "CustomerId", nullable = false)
        public long CustomerId;

        @Column( name = "BaselineNumber" , nullable = false)
        public long BaselineNumber;

    }

    @EmbeddedId
    private BaselineId baselineId;

    public Baseline(long customerId, long baselineNumber, String name, String description, String timestamp, String user) {
        baselineId = new BaselineId(customerId, baselineNumber);
        Name = name;
        Description = description;
        Timestamp = timestamp;
        User = user;
    }

    public long getCustomerId()
    {
        return baselineId.CustomerId;
    }

    public void setCustomerId(long customerId)
    {
        baselineId.CustomerId = customerId;
    }

    public long getBaselineNumber()
    {
        return baselineId.BaselineNumber;
    }

    public void setBaselineNumber( long baselineNumber )
    {
        baselineId.BaselineNumber = baselineNumber;
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

    private String Name;
    private String Description;
    private String Timestamp;
    private String User;
}
