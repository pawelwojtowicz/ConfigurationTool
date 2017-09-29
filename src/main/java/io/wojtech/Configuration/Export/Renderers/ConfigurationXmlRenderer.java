package io.wojtech.Configuration.Export.Renderers;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;






import io.wojtech.Configuration.Parameter.Parameter;

public class ConfigurationXmlRenderer implements IConfigRenderer{

	@Override
	public void initializeConfigurationRenderer(String filename) {
		// TODO Auto-generated method stub
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			document = docBuilder.newDocument();
			 			 
			configurationRoot = document.createElement("Configuration");	
			Attr versionAttribute = document.createAttribute("Version");
			versionAttribute.setValue("1.0");
			configurationRoot.setAttributeNode(versionAttribute);
			document.appendChild(configurationRoot);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void addParameter(Parameter parameter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizeConfiguration() {
		// TODO Auto-generated method stub
		
	}
	
	void addParameterUnderPath(Element configNode, String path , Parameter parameter) {
		if (path.isEmpty() ) {
			
			Element parameterNode = getParameterElemment(configNode, parameter.getName() );//document.createElement("Parameter");
			
			parameterNode.setAttribute("Key", parameter.getName());			
			parameterNode.setAttribute("Name", parameter.getDescription());
			parameterNode.setAttribute("DataType", parameter.getType());
			parameterNode.setAttribute("Unit", parameter.getUnit());
			parameterNode.setTextContent(parameter.getValue() );
		} else {
			int dotIndex = path.indexOf(".");
			
			String elementPath = path;
			
			if ( dotIndex != 0 ) {
				
			}
		}
	}

	private Element getParameterElemment(Element configNode , String name) {
		Element parameterElement = null;
		
		Node node = configNode.getFirstChild();
		
		while( node != null && parameterElement== null) {
			if ( node.getNodeName() == "Parameter" ) {
				NamedNodeMap attributes = node.getAttributes();
				
				Attr keyAttribute = (Attr)attributes.getNamedItem("Key");
				
				if (keyAttribute.getValue() == name) {
					parameterElement = (Element)node;
				}
			}
			node = node.getNextSibling();
		}
				
		if ( null != parameterElement ) {
			parameterElement = document.createElement("Parameter");
		}
		
		return parameterElement;
	}

	@Override
	public void getRenderersStream() {
		// TODO Auto-generated method stub
		
	}
	
	DocumentBuilder docBuilder;
	
	Document document;
	
	Element configurationRoot;

}
