package io.wojtech.Configuration.Export;

import io.wojtech.Configuration.ConfigurationItem.ConfigurationItem;
import io.wojtech.Configuration.CustomerContext.Configuration.Configuration;
import io.wojtech.Configuration.CustomerContext.ConfigurationElement.ConfigurationElement;
import io.wojtech.Configuration.CustomerContext.ConfigurationElementParameter.ConfigurationElementParameter;
import io.wojtech.Configuration.CustomerContext.Node.Node;
import io.wojtech.Configuration.Export.Renderers.IConfigRenderer;
import io.wojtech.Configuration.Parameter.Parameter;
import io.wojtech.Configuration.Parameter.ParameterToolbox;
import io.wojtech.Configuration.TemplateElement.TemplateElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017-10-02.
 */
public class ExportBuilder {
    public ExportBuilder(IConfigRenderer configRenderer) {
        configurationExportRenderer = configRenderer;
    }

    public void BuildConfigurationExport(Node node , ConfigurationItem configItem) {
        if ( null != configItem && ( configItem.getDefaultBase() != 0 ) ) {
            for ( Parameter parameter : configItem.getConfigItemParameters() ) {
                if ( parameter.getGenericPath() == 0 ) {
                    configurationExportRenderer.addParameter(parameter);
                }
            }
        }

        for ( Configuration configuration : node.getNodeConfiguration().getConfigurations() ) {
            for ( ConfigurationElement configElement : configuration.getConfigurationElements() ) {
                Map<Long , String> parameterValues = new HashMap<Long, String>();

                for ( ConfigurationElementParameter configElParameter: configElement.getConfigurationElementParameters() ) {
                    parameterValues.put(configElParameter.getTemplateParameterId(), configElParameter.getTemplateParameterValue() );
                }

                for ( TemplateElement templateElement : configElement.getTemplate().getTemplateElements() ) {

                    if (templateElement.getParameter().getConfigurationItemId() == configItem.getConfigurationItemId()) {

                        Parameter parameter = new Parameter(templateElement.getParameter());

                        String parameterValue = parameterValues.get(templateElement.getTemplateParameterId());

                        parameter.setValue(parameterValue);

                        if (ParameterToolbox.isGenericPath(parameter.getPath())) {
                            String paramPath = ParameterToolbox.replaceGenericPath(parameter.getPath(), configElement.getGenericTemplatePath());

                            parameter.setPath(paramPath);
                        }
                        configurationExportRenderer.addParameter(parameter);
                    }
                }

            }
        }

    }

    IConfigRenderer configurationExportRenderer;
}
