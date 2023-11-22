package com.Worldvision.core.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junit.framework.Assert;
import junitx.util.PrivateAccessor;

@ExtendWith({AemContextExtension.class,MockitoExtension.class})
public class RteComponentModelTest {
    @InjectMocks
    RteComponentModel rteComponent;

    @BeforeEach
    public void setup() throws NoSuchFieldException{

        PrivateAccessor.setField(rteComponent, "text", "<h1>hi this a mock</h1>");
    }

    @Test
    void testGetText() {
        Assert.assertEquals("<h1>hi this a mock</h1>", rteComponent.getText());
    }
}
