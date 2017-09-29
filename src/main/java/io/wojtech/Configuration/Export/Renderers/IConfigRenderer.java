package io.wojtech.Configuration.Export.Renderers;

import io.wojtech.Configuration.Parameter.Parameter;

public interface IConfigRenderer {
	void initializeConfigurationRenderer( String filename);
	
	void addParameter( Parameter parameter);
	
	void finalizeConfiguration();
	
	void getRenderersStream();

}
