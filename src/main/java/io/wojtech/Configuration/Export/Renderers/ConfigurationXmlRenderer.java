package io.wojtech.Configuration.Export.Renderers;


import jdk.nashorn.internal.runtime.regexp.joni.constants.NodeType;
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
import javax.xml.transform.stream.StreamResult;


import io.wojtech.Configuration.Parameter.Parameter;

import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

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

		if (parameter != null) {
			String[] pathLevelList = parameter.getPath().split(Pattern.quote("."));

			Element parametersParentNode = configurationRoot;

			for (int i = 0 ; i < pathLevelList.length ; ++i ) {
				String lnodePathName = pathLevelList[i];
				Element lnode = getLNode( parametersParentNode , lnodePathName );
				if ( lnode == null) {
					lnode = createLNode(lnodePathName);
					parametersParentNode.appendChild(lnode);
				}

				parametersParentNode = lnode;
			}

			if ( null != parametersParentNode ) {
				Element parameterElement = getParameter( parametersParentNode , parameter.getName() );

				if ( parameterElement != null ) {
					parameterElement.setNodeValue(parameter.getValue());
				} else {
					parameterElement = createParameter( parameter);
					parametersParentNode.appendChild(parameterElement);
				}
			}
		}
 	}

	@Override
	public void finalizeConfiguration() {
		// TODO Auto-generated method stub
		
	}

	private Element getLNode( Node parentNode, String lnodeName) {
		return getElementByTypeAndName( parentNode, "LNode", lnodeName);
	}

	private Element getParameter( Node parentNode , String parameterName ) {
		return getElementByTypeAndName(parentNode,"Parameter", parameterName);
	}


	private Element getElementByTypeAndName( Node parentNode , String elementTypeName ,String elementName ) {
		Element element = null;

		Node tempNode = parentNode.getFirstChild();

		while( (tempNode != null) && (element==null)) {
			if ( tempNode.getNodeType() == Node.ELEMENT_NODE ) {
				if ( tempNode.getNodeName() == elementTypeName ) {
					NamedNodeMap attributes = tempNode.getAttributes();
					Attr attribute = (Attr)attributes.getNamedItem("Key");
					if ( attribute != null ) {
						if ( elementName.equals(attribute.getValue()) ) {
						    element = (Element)tempNode;
						}
					}
				}
			}
            tempNode = tempNode.getNextSibling();
		}

		return element;
	}


	private Element createParameter( Parameter parameter) {
		Element parameterNode = document.createElement("Parameter");
		parameterNode.setAttribute("Key", parameter.getName());
		parameterNode.setAttribute("Name", parameter.getDescription());
		parameterNode.setAttribute("DataType", parameter.getType());
		parameterNode.setAttribute("Unit", parameter.getUnit());
		parameterNode.setTextContent(parameter.getValue());

		return parameterNode;
	}

	private Element createLNode( String lnodeKey ) {
		Element lNode = document.createElement("LNode");
		lNode.setAttribute("Key" , lnodeKey);
		return lNode;
	}


	@Override
	public byte[] getRenderersStream() throws TransformerException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);

		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		StreamResult result=new StreamResult(bos);
		transformer.transform(source, result);
		return bos.toByteArray();
	}
	
	DocumentBuilder docBuilder;
	
	Document document;
	
	Element configurationRoot;

}
