package io.wojtech.Configuration.Export.Renderers;

import io.wojtech.Configuration.Parameter.Parameter;

import javax.xml.transform.TransformerException;

public interface IConfigRenderer {
	void initializeConfigurationRenderer( String filename);
	
	void addParameter( Parameter parameter);
	
	void finalizeConfiguration();
	
	byte[] getRenderersStream() throws TransformerException;

}
