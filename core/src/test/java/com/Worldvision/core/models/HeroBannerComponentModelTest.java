package com.Worldvision.core.models;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junit.framework.Assert;
import junitx.util.PrivateAccessor;

@ExtendWith({AemContextExtension.class,MockitoExtension.class})
public class HeroBannerComponentModelTest {

    @InjectMocks
    HeroBannerComponentModel heroBannerComponent;

    @BeforeEach
    public void setup() throws NoSuchFieldException{
       PrivateAccessor.setField(heroBannerComponent, "enddate", end);
        PrivateAccessor.setField(heroBannerComponent, "startdate", start);
         PrivateAccessor.setField(heroBannerComponent, "title", "hero");

    }

    Date start=new Date(11,12,1776);
    Date end=new Date(1778, 2, 12);

    @Test
    void testGetEnddate() {
        Assert.assertEquals(end, heroBannerComponent.getEnddate());
    }

    @Test
    void testGetStartdate() {
        Assert.assertEquals(start, heroBannerComponent.getStartdate());
    }

    @Test
    void testGetTitle() {
        Assert.assertEquals("hero", heroBannerComponent.getTitle());
    }
}
