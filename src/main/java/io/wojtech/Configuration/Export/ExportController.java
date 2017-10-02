package io.wojtech.Configuration.Export;

import io.wojtech.Configuration.Export.Renderers.IConfigRenderer;
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

import javax.xml.transform.TransformerException;
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
    public ResponseEntity<byte[]> ExportSingleConfigItem( @PathVariable String nodeId, @PathVariable long configurationItemId) throws IOException, TransformerException {

        IConfigRenderer configRenderer =  exportService.ExportConfigItemForNode( configurationItemId, nodeId);
        byte[] xmlFileInBuffer = configRenderer.getRenderersStream();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setContentDispositionFormData("attachment", configRenderer.getConfigFilename());

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(xmlFileInBuffer.length)
                .body(xmlFileInBuffer);
    }


}
