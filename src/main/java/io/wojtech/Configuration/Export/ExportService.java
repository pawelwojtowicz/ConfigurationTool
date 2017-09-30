package io.wojtech.Configuration.Export;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import io.wojtech.Configuration.ConfigurationItem.ConfigurationItem;
import io.wojtech.Configuration.ConfigurationItem.ConfigurationItemRepository;
import io.wojtech.Configuration.CustomerContext.Configuration.Configuration;
import io.wojtech.Configuration.CustomerContext.ConfigurationElement.ConfigurationElement;
import io.wojtech.Configuration.CustomerContext.ConfigurationElementParameter.ConfigurationElementParameter;
import io.wojtech.Configuration.CustomerContext.Node.Node;
import io.wojtech.Configuration.CustomerContext.Node.NodeRepository;
import io.wojtech.Configuration.Export.Renderers.ConfigurationXmlRenderer;
import io.wojtech.Configuration.Export.Renderers.IConfigRenderer;
import io.wojtech.Configuration.Parameter.ParameterRepository;
import io.wojtech.Configuration.Parameter.Parameter;
import io.wojtech.Configuration.Parameter.ParameterToolbox;
import io.wojtech.Configuration.TemplateElement.TemplateElement;
import io.wojtech.Configuration.Template.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;

@Service
public class ExportService {
	
	@Autowired
	ParameterRepository parameterRepository;
	
	@Autowired
	ConfigurationItemRepository configurationItemRepository;
	
	@Autowired
	NodeRepository nodeRepository;

	public byte[] ExportConfigItemForNode(long configurationItemId, String nodeId) throws TransformerException {
		// TODO Auto-generated method stub
		
		Node nodeOfInterest = nodeRepository.findOne(nodeId);


		
		if ( null != nodeOfInterest ) {
			ConfigurationItem configForExporting = ExportToolbox.findConfiguration(nodeOfInterest.getDevice(), configurationItemId);
			IConfigRenderer configRenderer = new ConfigurationXmlRenderer();
			configRenderer.initializeConfigurationRenderer(configForExporting.getFileName());

			
			if ( null != configForExporting && ( configForExporting.getDefaultBase() != 0 ) ) {
				for ( Parameter parameter : configForExporting.getConfigItemParameters() ) {
					if ( parameter.getGenericPath() == 0 ) {
                        configRenderer.addParameter(parameter);
					}
				}
			}
			
			for ( Configuration configuration : nodeOfInterest.getNodeConfiguration().getConfigurations() ) {
				for ( ConfigurationElement configElement : configuration.getConfigurationElements() ) {
					Map<Long , String> parameterValues = new HashMap<Long, String>();
					
					for ( ConfigurationElementParameter configElParameter: configElement.getConfigurationElementParameters() ) {
						parameterValues.put(configElParameter.getTemplateParameterId(), configElParameter.getTemplateParameterValue() );
					}
					
					for ( TemplateElement templateElement : configElement.getTemplate().getTemplateElements() ) {

						Parameter parameter = new Parameter(templateElement.getParameter());

						String parameterValue = parameterValues.get( templateElement.getTemplateParameterId() );
						
						parameter.setValue(parameterValue);
						
						if ( ParameterToolbox.isGenericPath(parameter.getPath())) {
							String paramPath = ParameterToolbox.replaceGenericPath(parameter.getPath(), configElement.getGenericTemplatePath() );

                            parameter.setPath(paramPath);
						}
                        configRenderer.addParameter(parameter);
					}
					
				}
			}
			return configRenderer.getRenderersStream();
		}

		return null;

	}	
}
