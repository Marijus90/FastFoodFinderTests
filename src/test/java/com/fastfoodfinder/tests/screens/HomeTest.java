package com.fastfoodfinder.tests.screens;

import com.fastfoodfinder.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test(description = "The Home Screen loads successfully")
    public void testHomeScreenLoadsSuccessfully() {
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.dismissPrivacyDialogueIfPresent();

        assertTrue(homeScreen.isToolbarDisplayedCorrectly());
        assertTrue(homeScreen.listTabsAreDisplayed());

        assertTrue(homeScreen.isListPopulated());

        assertTrue(homeScreen.isBottomBannerDisplayed());
    }
}
