package io.wojtech.Configuration.ModuleConfigItemSetup;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-08-31.
 */
public interface ModuleConfigSetupRepository extends JpaRepository<ModuleConfigItemSetup,ModuleConfigItemSetup.ModuleConfigItemSetupId> {
}
