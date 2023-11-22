package com.Worldvision.core.models;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.framework.Assert;
import junitx.util.PrivateAccessor;

@ExtendWith({AemContextExtension.class,MockitoExtension.class})
public class CtaComponentTest {

@InjectMocks
CtaComponent ctaComponent;

@BeforeEach
public void setup() throws IOException{

    MockitoAnnotations.initMocks(this);
    try{
        PrivateAccessor.setField(ctaComponent,"link","Muni");
        PrivateAccessor.setField(ctaComponent,"buttonlabel","Button Label");
        PrivateAccessor.setField(ctaComponent,"optionsType","Options Type");
    }catch(NoSuchFieldException e) {
        e.printStackTrace();
    }
}

    @Test
    void testGetButtonlabel() {
    Assert.assertEquals("Button Label",ctaComponent.getButtonlabel());
    }

    @Test
    void testGetLink() {
Assert.assertEquals("Muni",ctaComponent.getLink());
    }

    @Test
    void testGetOptionsType() {
Assert.assertEquals("Options Type",ctaComponent.getOptionsType());
    }
}
