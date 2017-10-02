package io.wojtech.Configuration.Export.Renderers;

import io.wojtech.Configuration.Parameter.Parameter;
import org.springframework.http.MediaType;

import javax.xml.transform.TransformerException;

public interface IConfigRenderer {
	void initializeConfigurationRenderer( String filename);
	
	void addParameter( Parameter parameter);
	
	void finalizeConfiguration();
	
	byte[] getRenderersStream() throws TransformerException;

	MediaType getConfigitemMediaType();

	String getConfigFilename();

}
