package com.fastfoodfinder.tests;

import com.fastfoodfinder.tests.screens.DetailsScreen;
import com.fastfoodfinder.tests.screens.HomeMapScreen;
import org.testng.annotations.Test;

public class HomeMapTest extends BaseTest {
    // TODO - Mention this in the project description
    // Optional checks: Verify that user can interact with the map
    // Verify Map is scrollable
    // Verify Map zoom in/out
    // Verify Map buttons are clickable

    @Test(description = "The map and its elements load successfully")
    public void testMapLoadsSuccessfully() {
        HomeMapScreen mapScreen = new HomeMapScreen(driver);
        mapScreen.dismissPrivacyDialogueIfPresent();

        mapScreen.tapMapTab();
        mapScreen.isMapDisplayed();
        mapScreen.isMapMarkersDisplayed();
    }

    @Test(priority = 1, description = "Tapping on a location marker opens the details screen")
    public void testTappingOnLocationMarkerOpensDetailsScreen() {
        HomeMapScreen mapScreen = new HomeMapScreen(driver);
        DetailsScreen detailsScreen = new DetailsScreen(driver);
        mapScreen.dismissPrivacyDialogueIfPresent();

        mapScreen.tapMapTab();
        mapScreen.tapCustomMapMarker();
        mapScreen.isCustomMapMarkerInfoDisplayed();
        mapScreen.tapCustomMapMarkerInfo();

        detailsScreen.isTitleDisplayed();
    }
}
