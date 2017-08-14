package io.wojtech.Configuration.Release;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private long ReleaseId;
}
