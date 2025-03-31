package com.fastfoodfinder.tests.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private final By listItemLocator = By.xpath("//*[@resource-id='android:id/list']/*");

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

    // Bottom banner
    @AndroidFindBy(id = "de.pnpq.fflocator:id/adViewFlipper")
    private WebElement bottomBanner;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/adViewFlipperTextView1")
    private WebElement bottomBannerText;

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isToolbarDisplayedCorrectly() {
        return waitUntilElement(toolbar).isDisplayed()
                && waitUntilClickableElement(burgerMenu).isDisplayed()
                && waitUntilElement(titleText).isDisplayed()
                && waitUntilClickableElement(moreOptionsIcon).isDisplayed();
    }

    public boolean isListTabsDisplayed() {
        return waitUntilClickableElement(listTab).isDisplayed()
                && waitUntilElement(listTabText).isDisplayed()
                && waitUntilClickableElement(mapTab).isDisplayed()
                && waitUntilElement(mapTabText).isDisplayed();
    }

    public boolean isListPopulated() {
        waitUntilElement(locationsList).isDisplayed();
        return !driver.findElements(listItemLocator).isEmpty();
    }

    public boolean isBottomBannerDisplayed() {
        return waitUntilClickableElement(bottomBanner).isDisplayed()
                && waitUntilClickableElement(bottomBannerText).isDisplayed();

    }

    public void tapFirstPOIListItem() {
        try {
            waitUntilElement(locationsList).isDisplayed();
            driver.findElements(listItemLocator).get(0).click();
        } catch (Exception exception) {
            // An exception is thrown due to a race condition withing the Appium framework
        }
    }
}
