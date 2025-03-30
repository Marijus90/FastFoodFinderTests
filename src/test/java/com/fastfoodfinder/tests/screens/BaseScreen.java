package com.fastfoodfinder.tests.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseScreen {
    public static final Duration TIMEOUT = Duration.ofSeconds(10L);

    protected final AppiumDriver driver;
    protected final WebDriverWait wait;

    @AndroidFindBy(id = "de.pnpq.fflocator:id/consentTitleTextView")
    private WebElement privacyDrawerTitle;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/consentDeclineButton")
    private WebElement declineButton;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected WebElement waitUntilElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void dismissPrivacyDialogueIfPresent() {
        try {
            if (privacyDrawerTitle.isDisplayed()) {
                declineButton.click();
            }
        } catch (Exception ignored) {
            // Do nothing
        }
    }
}
