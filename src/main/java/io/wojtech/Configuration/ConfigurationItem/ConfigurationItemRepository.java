package io.wojtech.Configuration.ConfigurationItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.security.krb5.Config;

/**
 * Created by user on 2017-08-14.
 */
@Repository
public interface ConfigurationItemRepository extends JpaRepository<ConfigurationItem,Long> {
    ConfigurationItem findByConfigurationItemId(long configItemId);

}
