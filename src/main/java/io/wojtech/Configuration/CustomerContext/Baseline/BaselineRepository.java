package io.wojtech.Configuration.CustomerContext.Baseline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 2017-08-15.
 */
@Repository
public interface BaselineRepository extends JpaRepository<Baseline, Long> {
}
