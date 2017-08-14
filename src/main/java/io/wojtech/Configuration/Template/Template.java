package io.wojtech.Configuration.Template;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long TemplateId;
    private String Name;
    private String Description;
    private long OwnerId;
    private int TemplateStatus;
    private int Licensed;

}
