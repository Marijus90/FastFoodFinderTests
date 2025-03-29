package com.fastfoodfinder.tests;

import com.fastfoodfinder.tests.screens.PrivacySettingsDialogue;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PrivacySettingTest extends BaseTest {

    @Test(priority = 1, description = "The Privacy Policy clickable text link is clickable")
    public void testPrivacyPolicyLinkIsClickable() {
        PrivacySettingsDialogue dialogue = new PrivacySettingsDialogue(driver);
        assertTrue(dialogue.isPrivacyPolicyLinkClickable(), "Privacy Policy link should be clickable and shown.");
    }

    @Test(priority = 2, description = "The Privacy settings drawer is shown, and dismissible by accepting, and does not reappear on subsequent launches")
    public void testAcceptingPrivacySettingsDismissTheDialogue() {
        PrivacySettingsDialogue dialogue = new PrivacySettingsDialogue(driver);
        assertTrue(dialogue.isPrivacyDrawerDisplayed(), "Privacy settings drawer should be visible on first launch.");
        dialogue.acceptPrivacySettings();
        assertFalse(dialogue.isPrivacyDrawerDisplayed(), "Privacy settings drawer should disappear after accepting.");
        restartApp();
        assertFalse(dialogue.isPrivacyDrawerDisplayed(), "Privacy settings drawer should not reappear after acceptance/decline.");
    }

    @Test(priority = 3, description = "The Privacy settings drawer is shown, and dismissible by declining, and does not reappear on subsequent launches")
    public void testDecliningPrivacySettingsDismissTheDialogue() {
        PrivacySettingsDialogue dialogue = new PrivacySettingsDialogue(driver);
        assertTrue(dialogue.isPrivacyDrawerDisplayed(), "Privacy settings drawer should be visible on first launch.");
        dialogue.declinePrivacySettings();
        assertFalse(dialogue.isPrivacyDrawerDisplayed(), "Privacy settings drawer should disappear after declining.");
        restartApp();
        assertFalse(dialogue.isPrivacyDrawerDisplayed(), "Privacy settings drawer should not reappear after acceptance/decline.");
    }

    private void restartApp() {
        driver.terminateApp("de.pnpq.fflocator");
        driver.activateApp("de.pnpq.fflocator");
    }

}
