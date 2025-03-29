package com.fastfoodfinder.tests.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivacySettingsDialogue {
    public static final Duration TIMEOUT = Duration.ofSeconds(10L);
    private final WebDriverWait wait;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/consentTitleTextView")
    private WebElement privacyDrawerTitle;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/consentTextView")
    private WebElement privacyDrawerDescriptionText;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Privacy Policy')]")
    private WebElement privacyPolicyLink;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/consentAcceptButton")
    private WebElement acceptButton;
    @AndroidFindBy(id = "de.pnpq.fflocator:id/consentDeclineButton")
    private WebElement declineButton;

    public PrivacySettingsDialogue(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver, TIMEOUT), this);
    }

    public boolean isPrivacyDrawerDisplayed() {
        // TODO - Move the visibility checks into a helper method
        try {
            boolean isPrivacyDrawerTitleDisplayed = wait.until(ExpectedConditions.visibilityOf(privacyDrawerTitle)).isDisplayed();
            boolean isPrivacyDrawerTextDisplayed = wait.until(ExpectedConditions.visibilityOf(privacyDrawerDescriptionText)).isDisplayed();
            return isPrivacyDrawerTitleDisplayed && isPrivacyDrawerTextDisplayed;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPrivacyPolicyLinkClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).isDisplayed();
    }

    public void acceptPrivacySettings() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
    }

    public void declinePrivacySettings() {
        wait.until(ExpectedConditions.elementToBeClickable(declineButton)).click();
    }
}
