package io.wojtech.Configuration.TemplateDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class TemplateDependencyService {
    @Autowired
    TemplateDependencyRepository templateDependencyRepository;

    public void addDependency( TemplateDependency templateDependency)
    {
        templateDependencyRepository.save( templateDependency );
    }

    public void deleteDependency(long templateId, long requiredTemplateId )
    {
        TemplateDependency.TemplateDependencyId templateDependencyId = new TemplateDependency.TemplateDependencyId(templateId,requiredTemplateId);

        templateDependencyRepository.delete(templateDependencyId);
    }

    public List<TemplateDependency> getAllDependencies()
    {
        return templateDependencyRepository.findAll();
    }

    public List<TemplateDependency> getDependenciesForTemplate( long templateId)
    {
        return templateDependencyRepository.findByTemplateDependencyIdTemplateId(templateId);
    }

    @Transactional
    public long deleteTemplateDependencies(long templateId ) {
        return templateDependencyRepository.deleteByTemplateDependencyIdTemplateId(templateId);
    }
}
