package io.wojtech.Configuration.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;

    @RequestMapping( method= RequestMethod.POST, value = "/modules")
    public void addModule(@RequestBody Module module)
    {
        moduleRepository.save(module);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/modules")
    public void updateModule(@RequestBody Module module)
    {
        moduleRepository.save(module);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/modules")
    public List<Module> getModules()
    {
        return moduleRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/modules/{moduleId}")
    public void deleteModule( @PathVariable long moduleId)
    {
        moduleRepository.delete(moduleId);
    }


}
