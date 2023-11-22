package com.Worldvision.core.models;

import java.util.Date;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class HeroBannerComponentModel {

  @ValueMapValue(name = "title", injectionStrategy = InjectionStrategy.OPTIONAL)
  private String title;

  public String getTitle() {
    return title;
}

public Date getStartdate() {
    return startdate;
}

public String getFileReference() {
  return fileReference;
}

public Date getEnddate() {
    return enddate;
}

@ValueMapValue(name = "startdate", injectionStrategy = InjectionStrategy.OPTIONAL)
  private Date startdate;

  @ValueMapValue(name = "enddate", injectionStrategy = InjectionStrategy.OPTIONAL)
  private Date enddate;

  @ValueMapValue(name = "fileReference", injectionStrategy = InjectionStrategy.OPTIONAL)
  private String fileReference;

}
