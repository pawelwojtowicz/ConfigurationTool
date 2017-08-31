package io.wojtech.Configuration.ModuleConfigItemSetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2017-08-31.
 */
@Service
public class ModuleConfigSetupService {

    @Autowired
    ModuleConfigSetupRepository repository;

    void addModuleConfigItemSetup( ModuleConfigItemSetup association) {
        repository.save(association);
    }

    void deleteConfigItemSetup( ModuleConfigItemSetup association) {
        repository.delete(association);
    }
}
