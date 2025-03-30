package com.fastfoodfinder.tests.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DetailsScreen extends BaseScreen {
    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Details\"]")
    private WebElement titleText;

    public DetailsScreen(AppiumDriver driver) {
        super(driver);
    }

    public void isTitleDisplayed() {
        waitUntilElement(titleText).isDisplayed();
    }

    // DS-0
    // Title: Verify Details Screen Loads and Displays Correct Information
    // Start the app
    // Navigate to Details
    // Verify Toolbar icons are clickable
    // Verify correct information is displayed
    // Verify Map and Images tabs are clickable
    // Verify Map loads
    // Click Images
    // Verify Images map view loads

    // DS-1
    // Title: Tapping Navigate icon starts the correct navigation intent
    // Start the app
    // Navigate to Details
    // Click navigate
    // Verify Android intent ?
}
