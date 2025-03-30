package com.fastfoodfinder.tests.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeMapScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Map")
    private WebElement mapTab;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"de.pnpq.fflocator:id/mapView\"]/android.widget.FrameLayout/android.widget.RelativeLayout[2]")
    private WebElement mapLayout;
    @AndroidFindBy(accessibility = "Stage Left Cafe")
    private WebElement customMapMarker;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='de.pnpq.fflocator:id/mapView']/android.widget.FrameLayout/android.widget.RelativeLayout[2]//android.widget.TextView[contains(@text, 'Stage Left Cafe')]")
    private WebElement stageLeftCafeTitleText;

    public HomeMapScreen(AppiumDriver driver) {
        super(driver);
    }

    public void isMapDisplayed() {
        waitUntilElement(mapLayout).isDisplayed();
    }

    public void isMapMarkersDisplayed() {
        waitUntilElement(customMapMarker).isDisplayed();
    }

    public void isCustomMapMarkerInfoDisplayed() {
        waitUntilClickableElement(stageLeftCafeTitleText).isDisplayed();
    }

    public void tapCustomMapMarkerInfo() {
        waitUntilClickableElement(stageLeftCafeTitleText).click();
    }

    public void tapMapTab() {
        waitUntilClickableElement(mapTab).click();
    }

    public void tapCustomMapMarker() {
        waitUntilClickableElement(customMapMarker).click();
    }
}
