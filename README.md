# Appium Test Project - Map Based Android App

This project is a Maven-based application for performing automated tests using Appium. It is structured to facilitate easy testing of mobile applications and incorporate the usage of POM pattern.

## Project Structure

```
FastFoodFinderTests
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── fastfoodfinder
│   │               └── tests
│   │                   └── App.java
│   └──  test
│       └── java
│           └── com
│               └── fastfoodfinder
│                   └── tests
│                       └── helper
│                       |    └── AppTestUtils.java
|                       └── screens
│                       |    └── BaseScreen.java
│                       |    └── DetailsScreen.java
│                       |    └── HomeMapScreen.java
│                       |    └── HomeScreen.java
|                       └── BaseTest.java
│                       └── DetailsScreenTeest.java
│                       └── HomeMapTest.java
│                       └── HomeTest.java
├── test-output
|   └── ExtentReport.html
├── srceenshot
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd FastFoodFinderTests
   ```

2. **Install Maven**
   Ensure that Maven is installed on your machine. You can download it from [Maven's official website](https://maven.apache.org/download.cgi).

3. **Build the Project**
   Run the following command to build the project:
   ```bash
   mvn clean install
   ```

4. **Run Tests**
   To execute the tests, use the following command:
   ```bash
   mvn test
   ```

## Usage

- The `BaseTest.java` file contains methods for initializing the Appium driver, screenshot capture on failure, test report generation setup and teardown, and teardown of the driver.
- The `com.fastfoodfindeer.tests` package includes test cases that utilize Appium to perform automated tests on the application, screen classes, and a helper utility class.

## Dependencies

This project uses the following dependencies:
- Appium Java Client
- TestNG
- Extent Reports
- JUnit

## Prerequisites

This project requires Java and Appium to be installed prior to run, otherwise your tests will not run successfully.

## Known Issues And Limitations

- **Element Selection Issue:** One test case fails due to Appium selecting an incorrect element, despite using the correct identifier. This may be an internal Appium issue related to element recognition.
- **Race Condition in Details Screen Test:** The test for the details screen throws an exception due to a race condition when tapping on an element in a list. If the exception is caught, the test completes successfully. This is likely an internal issue within Appium's handling of element interactions.
- **Project Improvements:** There are opportunities for further optimization and tidying of the project, such as moving the driver setup into a dedicated configuration file to enhance maintainability and modularity, etc.
- **Extent Reports Visual Clutter:** I've observed that Extent Reports adds some visual clutter to the test case reports. To minimize repetition, I have removed test descriptions from the top of the test methods.
- **Test Failure Logging (Pending):** Logging test failures in Extent Reports is something I would implement if I had more time to work on the project.
- **Screenshot Attachment (Pending):** Attaching a screenshot of test failures in the Extent Reports is also something I would implement if I had additional time.
- **CI/CD:** I would have inegrated the Appium Tests to run on a CI/CD pipeline if I had more time.
- **UI Element Properties:** Appium does have some limitations when it comes to verifying certain UI element properties such as colors, icon IDs, and detailed styles. Native testing frameworks offer more granular access to such properties, which may be important for certain types of tests (like UI validation tests).  Despite these limitations, Appium seems like an excellent choice for end-to-end and integration tests. 

# Raising a JIRA Ticket For The Failed Test

The automated tests have detected an actual bug in the app, and it was verified to be present by a manual test as well.

## Bug Report: [APP-0001] [Android] Tapping a clustered custom map marker selects a wrong POI

**Project**: FastFoodFinder App
**Epic**: Initial release
**Assignee**: Unassigned
**Priority**: Major (defined by the PO)  
**Severity**: Minor
**Frequency**: Always
**Environment**: Develop 
- Android Version: 14
- Device: Google Pixel 9 Pro 
- App Build version: v1.0

## Description
In the Map tab, on the Home screen, when a clustered marker is tapped, a wrong marker is focused on.

---
## Preconditions
There should be a cluster of markers on the map.

## Steps to Reproduce
1. Navigate to the Map tab on the Home page.
2. Keep the map in a default zoomed-out state.
3. Tap precisely on some markers in a cluster.
   
---

## Expected Result
The specific marker that was tapped on should be focused on.

---

## Actual Result
Usually, the most far-out marker in a clusted is focused on.

---

## Additional info (logs)
None

## Screenshots/Video attached
![Screenshot 2025-03-31 011500](https://github.com/user-attachments/assets/b4f2bdb5-cd42-4cd5-b515-0e18fb69d9a1)
![Screenshot 2025-03-31 011426](https://github.com/user-attachments/assets/6c54be66-bb2b-44a1-bed7-9a0973b7acb1)


