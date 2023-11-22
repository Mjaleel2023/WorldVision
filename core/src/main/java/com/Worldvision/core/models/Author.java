package com.Worldvision.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { Author.class, ComponentExporter.class },
    resourceType = Author.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)

public class Author implements ComponentExporter {

    @ValueMapValue(name = "./fname")
    private String fname;

    @ValueMapValue(name = "./lname")
    private String lname;

    static final String RESOURCE_TYPE = "Worldvision/components/author";

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}
