package com.Worldvision.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class CtaComponent {
    @ValueMapValue(name = "link", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String link;

    @ValueMapValue(name = "buttonlabel", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String buttonlabel;

    @ValueMapValue(name = "optionsType", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String optionsType;

    public String getLink() {
        return link;
    }


    public String getButtonlabel() {
        return buttonlabel;
    }


    public String getOptionsType() {
        return optionsType;
    }

}
