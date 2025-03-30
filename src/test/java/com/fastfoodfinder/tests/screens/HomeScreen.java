package com.fastfoodfinder.tests.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    // Toolbar
    @AndroidFindBy(id = "de.pnpq.fflocator:id/toolbar")
    private WebElement toolbar;
    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement burgerMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Nearby\"]")
    private WebElement titleText;
    @AndroidFindBy(accessibility = "More options")
    private WebElement moreOptionsIcon;

    // List tabs
    @AndroidFindBy(accessibility = "List")
    private WebElement listTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"List\"]")
    private WebElement listTabText;
    @AndroidFindBy(accessibility = "Map")
    private WebElement mapTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Map\"]")
    private WebElement mapTabText;

    // List and its items
    @AndroidFindBy(id = "android:id/list")
    private WebElement locationsList;
    private final By listItemLocator = By.xpath("//*[@resource-id='android:id/list']/*");

    // Bottom banner
    @AndroidFindBy(id = "de.pnpq.fflocator:id/adViewFlipper")
    private WebElement bottomBanner;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/adViewFlipperTextView1")
    private WebElement bottomBannerText;

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isToolbarDisplayedCorrectly() {
        try {
            return waitUntilElement(toolbar).isDisplayed()
                    && waitUntilClickableElement(burgerMenu).isDisplayed()
                    && waitUntilElement(titleText).isDisplayed()
                    && waitUntilClickableElement(moreOptionsIcon).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean listTabsAreDisplayed() {
        try {
            return waitUntilClickableElement(listTab).isDisplayed()
                    && waitUntilElement(listTabText).isDisplayed()
                    && waitUntilClickableElement(mapTab).isDisplayed()
                    && waitUntilElement(mapTabText).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean isListPopulated() {
        try {
            // Wait for the list to be visible
            waitUntilElement(locationsList).isDisplayed();

            // Check if the list has at least one child element (list item)
            return !driver.findElements(listItemLocator).isEmpty();
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean isBottomBannerDisplayed() {
        try {
            return waitUntilClickableElement(bottomBanner).isDisplayed()
                    && waitUntilClickableElement(bottomBannerText).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }
}
