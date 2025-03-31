package com.fastfoodfinder.tests;

import com.fastfoodfinder.tests.screens.HomeScreen;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void testHomeScreenLoadsSuccessfully() {
        test.info("Starting test: The Home screen loads successfully");
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.dismissPrivacyDialogueIfPresent();

        assertTrue(homeScreen.isToolbarDisplayedCorrectly());
        assertTrue(homeScreen.isListTabsDisplayed());

        assertTrue(homeScreen.isListPopulated());

        assertTrue(homeScreen.isBottomBannerDisplayed());
        test.pass("Home screen loaded successfully");
    }
}
