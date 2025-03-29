package com.fastfoodfinder.tests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class AppLaunchTest extends BaseTest {

    private final String TITLE_ID = "//android.widget.TextView[@text=\"FastFoodFinder\"]";

    @Test(description = "The app launches and the title is shown")
    public void testAppLaunch() {
        assertTrue(driver.findElement(AppiumBy.xpath(TITLE_ID)).isDisplayed());
    }

}
