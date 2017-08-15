package io.wojtech.Configuration.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    public void addModule(Module module)
    {
        moduleRepository.save(module);
    }

    public void updateModule(Module module)
    {
        moduleRepository.save(module);
    }

    public List<Module> getModules()
    {
        return moduleRepository.findAll();
    }

    public void deleteModule( long moduleId)
    {
        moduleRepository.delete(moduleId);
    }


}
