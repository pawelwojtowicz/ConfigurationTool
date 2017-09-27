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
import io.wojtech.Configuration.Parameter.ParameterRepository;
import io.wojtech.Configuration.Parameter.Parameter;
import io.wojtech.Configuration.Parameter.ParameterToolbox;
import io.wojtech.Configuration.TemplateElement.TemplateElement;
import io.wojtech.Configuration.Template.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportService {
	
	@Autowired
	ParameterRepository parameterRepository;
	
	@Autowired
	ConfigurationItemRepository configurationItemRepository;
	
	@Autowired
	NodeRepository nodeRepository;

	public List<Parameter> ExportConfigItemForNode(long configurationItemId, String nodeId) {
		// TODO Auto-generated method stub
		
		Node nodeOfInterest = nodeRepository.findOne(nodeId);
		
		Map<Long, Parameter> parametersMap = new HashMap<Long, Parameter>();

		
		if ( null != nodeOfInterest ) {
			ConfigurationItem configForExporting = ExportToolbox.findConfiguration(nodeOfInterest.getDevice(), configurationItemId);
			
			
			if ( null != configForExporting && ( configForExporting.getDefaultBase() != 0 ) ) {
				for ( Parameter parameter : configForExporting.getConfigItemParameters() ) {
					if ( parameter.getGenericPath() == 0 ) {
						parametersMap.put( parameter.getParameterId() , parameter);
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
						
						Parameter parameter = parametersMap.get( templateElement.getParameterId() );
						
						if (null == parameter) {
							parameter = templateElement.getParameter();
						}
						
						String parameterValue = parameterValues.get( templateElement.getTemplateParameterId() );
						
						parameter.setValue(parameterValue);
						
						if ( ParameterToolbox.isGenericPath(parameter.getPath())) {
							String paramPath = ParameterToolbox.replaceGenericPath(parameter.getPath(), configElement.getGenericTemplatePath() );
							
							parameter.setPath(paramPath);
						}
						
						parametersMap.put(templateElement.getParameterId(), parameter);
					}
					
				}
			}
		}
		
		List<Parameter> outputValue = new Vector<Parameter>(); 
		
		for ( Parameter parameter : parametersMap.values()) {
			outputValue.add(parameter);
		}
		
		return outputValue;

	}	
}
