package io.wojtech.Configuration.Export;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import io.wojtech.Configuration.Parameter.Parameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


/**
 * Created by user on 2017-08-14.
 */
@RestController
public class ExportController {

    @Autowired
    ExportService exportService;
	
    @RequestMapping(path = "/exportconfig/{nodeId}/{configurationItemId}", method= RequestMethod.GET)
    public List<Parameter> ExportSingleConfigItem( @PathVariable String nodeId, @PathVariable long configurationItemId) throws IOException
    {
  //      InputStreamResource fileStream = new InputStreamResource(new FileInputStream("c:\\Filename.txt"));
  //      HttpHeaders headers = new HttpHeaders();

        
    return exportService.ExportConfigItemForNode( configurationItemId, nodeId);
        
    }


}
