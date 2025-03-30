package com.fastfoodfinder.tests;

import com.fastfoodfinder.tests.screens.HomeScreen;
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
