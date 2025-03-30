package com.fastfoodfinder.tests;

import com.fastfoodfinder.tests.helper.AppTestUtils;
import com.fastfoodfinder.tests.screens.DetailsScreen;
import com.fastfoodfinder.tests.screens.HomeScreen;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DetailsScreenTest extends BaseTest {

    private static final String GOOGLE_MAPS_APP_PACKAGE_NAME = "de.pnpq.osmlocator.base.activities.AppMainActivity";

    @Test
    public void testDetailsScreenLoadsSuccessfully() {
        test.info("Starting test: The Details screen loads successfully");
        HomeScreen homeScreen = new HomeScreen(driver);
        DetailsScreen detailsScreen = new DetailsScreen(driver);
        homeScreen.dismissPrivacyDialogueIfPresent();

        homeScreen.tapFirstPOIListItem();

        assertTrue(detailsScreen.isToolbarDisplayedCorrectly());
        assertTrue(detailsScreen.isPOIDetailsDisplayedCorrectly());
        assertTrue(detailsScreen.isMapDisplayed());
        assertTrue(detailsScreen.isMapMarkerDisplayed());

        assertTrue(homeScreen.isBottomBannerDisplayed());
        test.pass("Finished test: The Details screen loaded successfully");
    }

    @Test(priority = 1)
    public void testNavigateIconStartsNavigationIntent() {
        test.info("Starting test: Tapping Navigate icon starts the correct navigation intent");
        HomeScreen homeScreen = new HomeScreen(driver);
        DetailsScreen detailsScreen = new DetailsScreen(driver);
        homeScreen.dismissPrivacyDialogueIfPresent();

        homeScreen.tapFirstPOIListItem();

        detailsScreen.tapNavigateTo();
        assertTrue(AppTestUtils.isExternalAppOpened(driver, GOOGLE_MAPS_APP_PACKAGE_NAME));
        test.pass("Finished test: Tapping the Navigate icon stared a Google Maps navigation intent");
    }
}
