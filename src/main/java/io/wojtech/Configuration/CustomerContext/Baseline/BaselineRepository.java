package io.wojtech.Configuration.CustomerContext.Baseline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 2017-08-15.
 */
@Repository
public interface BaselineRepository extends JpaRepository<Baseline, Long> {
    List<Baseline> findByCustomerId(long customerId);
}
