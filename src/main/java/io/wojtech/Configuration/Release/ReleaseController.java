package io.wojtech.Configuration.Release;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
@RestController
public class ReleaseController {
    @Autowired ReleaseRepository releaseRepository;

    @RequestMapping( method = RequestMethod.POST, value = "/release")
    void addRelease(@RequestBody Release release)
    {
        releaseRepository.save(release);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/release")
    void updateRelease(@RequestBody Release release)
    {
        releaseRepository.save(release);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/release/{releaseId}")
    void updateRelease(@PathVariable long releaseId)
    {
        releaseRepository.delete(releaseId);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/release")
    List<Release> getAllReleases()
    {
        return releaseRepository.findAll();
    }


}
