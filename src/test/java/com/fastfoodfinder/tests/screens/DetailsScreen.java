package com.fastfoodfinder.tests.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DetailsScreen extends BaseScreen {
    // Toolbar
    @AndroidFindBy(id = "de.pnpq.fflocator:id/toolbar")
    private WebElement toolbar;
    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Details\"]")
    private WebElement titleText;
    @AndroidFindBy(accessibility = "Navigate here")
    private WebElement navigateHereIcon;
    @AndroidFindBy(accessibility = "Search for more info online")
    private WebElement moreInfoIcon;
    @AndroidFindBy(accessibility = "More options")
    private WebElement moreOptionsIcon;

    // POI details
    @AndroidFindBy(accessibility = "Logo")
    private WebElement logoImage;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/poiDetailsTitleTextView")
    private WebElement poiDetailsTitle;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/listItemTextView")
    private WebElement poiAddressText;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/listItemDistanceView")
    private WebElement poiDistanceText;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/listItemCompassView")
    private WebElement poiCompass;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/poiDetailsOpenWebsiteButton")
    private WebElement openWebsiteButton;

    // Tabs
    @AndroidFindBy(accessibility = "Map")
    private WebElement mapTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Map\"]")
    private WebElement mapTabText;
    @AndroidFindBy(accessibility = "Images")
    private WebElement imagesTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Images\"]")
    private WebElement imagesTabText;

    // Map
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"de.pnpq.fflocator:id/mapView\"]/android.widget.FrameLayout/android.widget.RelativeLayout[2]")
    private WebElement mapLayout;
    @AndroidFindBy(accessibility = "Map Marker")
    private WebElement customMapMarker;

    public DetailsScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return waitUntilElement(titleText).isDisplayed();
    }

    public boolean isToolbarDisplayedCorrectly() {
        return waitUntilElement(toolbar).isDisplayed()
                && waitUntilClickableElement(backIcon).isDisplayed()
                && waitUntilElement(titleText).isDisplayed()
                && waitUntilClickableElement(navigateHereIcon).isDisplayed()
                && waitUntilClickableElement(moreInfoIcon).isDisplayed()
                && waitUntilClickableElement(moreOptionsIcon).isDisplayed();
    }

    public boolean isPOIDetailsDisplayedCorrectly() {
        return waitUntilElement(logoImage).isDisplayed()
                && waitUntilElement(poiDetailsTitle).isDisplayed()
                && waitUntilElement(poiAddressText).isDisplayed()
                && waitUntilElement(poiDistanceText).isDisplayed()
                && waitUntilElement(poiCompass).isDisplayed()
                && waitUntilClickableElement(openWebsiteButton).isDisplayed()
                && waitUntilClickableElement(mapTab).isDisplayed()
                && waitUntilClickableElement(mapTabText).isDisplayed()
                && waitUntilClickableElement(imagesTab).isDisplayed()
                && waitUntilClickableElement(imagesTabText).isDisplayed();

    }

    public boolean isMapDisplayed() {
        return waitUntilElement(mapLayout).isDisplayed();
    }

    public boolean isMapMarkerDisplayed() {
        return waitUntilElement(customMapMarker).isDisplayed();
    }

    public void tapNavigateTo() {
        waitUntilClickableElement(navigateHereIcon).click();
    }
}
