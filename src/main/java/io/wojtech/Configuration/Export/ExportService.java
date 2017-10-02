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
import io.wojtech.Configuration.Export.Renderers.RendererFactory;
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
	
	//Autowired
	//ParameterRepository parameterRepository;
	
	//@Autowired
	//ConfigurationItemRepository configurationItemRepository;
	
	@Autowired
	NodeRepository nodeRepository;

	public IConfigRenderer ExportConfigItemForNode(long configurationItemId, String nodeId) throws TransformerException {
		// TODO Auto-generated method stub
		
		Node nodeOfInterest = nodeRepository.findOne(nodeId);


		
		if ( null != nodeOfInterest ) {

			// get the configuration item info, that shall be exported
			ConfigurationItem configForExporting = ExportToolbox.findConfiguration(nodeOfInterest.getDevice(), configurationItemId);

			// obtain the renderer for export type
			IConfigRenderer configRenderer = RendererFactory.getConfigRenderer(configForExporting.getExportType());

			if ( configRenderer != null ) {
				//initialize the renderer
				configRenderer.initializeConfigurationRenderer(configForExporting.getFileName());

				//pass the renderer to configuration builder
				ExportBuilder configurationBuilder = new ExportBuilder(configRenderer);

				//generate the configuration item for selected node.
				configurationBuilder.BuildConfigurationExport(nodeOfInterest, configForExporting);
			}
			return configRenderer;
		}

		return null;

	}	
}
