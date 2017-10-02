package io.wojtech.Configuration.Export.Renderers;

/**
 * Created by user on 2017-10-02.
 */
public class RendererFactory {
    public static IConfigRenderer getConfigRenderer(String exportTypeName ) {
        IConfigRenderer configRenderer = null;

//        if (exportTypeName.equals("Config.xml")) {
            configRenderer = new ConfigurationXmlRenderer();
            //       }

        return configRenderer;
    }
}
