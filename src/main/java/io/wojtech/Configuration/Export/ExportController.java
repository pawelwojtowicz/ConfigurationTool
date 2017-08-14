package io.wojtech.Configuration.Export;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * Created by user on 2017-08-14.
 */
@RestController
public class ExportController {

    @RequestMapping(path = "/exportconfig/{moduleType}/{configType}", method= RequestMethod.GET)
    public ResponseEntity<InputStreamResource> ExportSingleConfigItem( long moduleType, long configType) throws IOException
    {
        InputStreamResource fileStream = new InputStreamResource(new FileInputStream("c:\\Filename.txt"));
        HttpHeaders headers = new HttpHeaders();

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(fileStream.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(fileStream);
    }


}
