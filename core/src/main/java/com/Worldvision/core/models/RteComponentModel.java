package com.Worldvision.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class RteComponentModel {
    
    @ValueMapValue(name = "jcr:description", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String text;

    public String getText() {
        return text;
    }

    
}
