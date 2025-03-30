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

    public boolean isMapDisplayed() {
        return waitUntilElement(mapLayout).isDisplayed();
    }

    public boolean isMapMarkersDisplayed() {
        return waitUntilElement(customMapMarker).isDisplayed();
    }

    public boolean isCustomMapMarkerInfoDisplayed() {
        return waitUntilClickableElement(stageLeftCafeTitleText).isDisplayed();
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

