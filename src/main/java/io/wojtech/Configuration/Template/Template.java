package io.wojtech.Configuration.Template;

import io.wojtech.Configuration.TemplateElement.TemplateElement;
import io.wojtech.Configuration.TemplateParameter.TemplateParameter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 2017-08-13.
 */
@Entity
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long templateId;
    private String Name;
    private String Description;
    private long OwnerId;
    private int TemplateStatus;
    private int Licensed;

    @OneToMany(mappedBy = "parentTemplate", cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    Set<TemplateParameter> templateParameters;

    @OneToMany(mappedBy = "parentTemplate", cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
    Set<TemplateElement> templateElements;

}
