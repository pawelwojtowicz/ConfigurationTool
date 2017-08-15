package io.wojtech.Configuration.Release;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@Service
public class ReleaseService {
    @Autowired ReleaseRepository releaseRepository;

    void addRelease(@RequestBody Release release)
    {
        releaseRepository.save(release);
    }

    void updateRelease(@RequestBody Release release)
    {
        releaseRepository.save(release);
    }

    void deleteRelease(@PathVariable long releaseId)
    {
        releaseRepository.delete(releaseId);
    }

    List<Release> getAllReleases()
    {
        return releaseRepository.findAll();
    }


}
