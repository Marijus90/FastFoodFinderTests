package com.fastfoodfinder.tests.helper;

import io.appium.java_client.AppiumDriver;

public class AppTestUtils {

    public static boolean isExternalAppOpened(AppiumDriver driver, String expectedPackageName) {
        int retries = 5;
        int delay = 1000;

        for (int i = 0; i < retries; i++) {
            if (driver.getCapabilities().getCapability("appActivity").equals(expectedPackageName)) {
                return true;
            }
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                // Do nothing
            }
        }
        return false;
    }
}
