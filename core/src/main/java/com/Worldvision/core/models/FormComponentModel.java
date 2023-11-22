package com.Worldvision.core.models;

import javax.annotation.Resource;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class },
  defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FormComponentModel {
    

@ValueMapValue(name = "./eid")
private String employee_id;

@ValueMapValue(name = "./fname")
private String first_name;

@ValueMapValue(name = "./lname")
private String last_name;

@ValueMapValue(name = "./address")
private String address;

@ValueMapValue(name = "./submit")
private String Submit;

public String getEmployee_id() {
    return employee_id;
}

public String getFirst_name() {
    return first_name;
}

public String getLast_name() {
    return last_name;
}

public String getAddress() {
    return address;
}

public String getSubmit() {
    return Submit;
}



}
