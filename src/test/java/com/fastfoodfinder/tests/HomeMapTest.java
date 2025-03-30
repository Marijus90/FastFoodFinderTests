package com.fastfoodfinder.tests;

import com.fastfoodfinder.tests.screens.DetailsScreen;
import com.fastfoodfinder.tests.screens.HomeMapScreen;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeMapTest extends BaseTest {

    @Test
    public void testMapLoadsSuccessfully() {
        test.info("Starting test: The map and its elements load successfully");
        HomeMapScreen mapScreen = new HomeMapScreen(driver);
        mapScreen.dismissPrivacyDialogueIfPresent();

        mapScreen.tapMapTab();
        test.info("Step: Navigated to Map tab successfully");
        assertTrue(mapScreen.isMapDisplayed());
        assertTrue(mapScreen.isMapMarkersDisplayed());
        test.pass("Finished test: The map and its elements loaded successfully");
    }

    @Test(priority = 1)
    public void testTappingOnCustomMarkerOpensDetailsScreen() {
        test.info("Starting test: Tapping on a custom map marker opens the details screen");
        HomeMapScreen mapScreen = new HomeMapScreen(driver);
        DetailsScreen detailsScreen = new DetailsScreen(driver);
        mapScreen.dismissPrivacyDialogueIfPresent();

        mapScreen.tapMapTab();
        test.info("Step: Navigated to Map tab successfully");
        mapScreen.tapCustomMapMarker();
        assertTrue(mapScreen.isCustomMapMarkerInfoDisplayed());
        mapScreen.tapCustomMapMarkerInfo();

        assertTrue(detailsScreen.isTitleDisplayed());
        test.pass("Finished test: Details screen was opened successfully");
    }
}
