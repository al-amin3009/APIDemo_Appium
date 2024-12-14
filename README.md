# APIDemo Appium Automation Project
## Overview
This is an Appium-based mobile automation framework for testing the Android API Demos application, demonstrating mobile test automation using Java, Appium, and TestNG.
## Prerequisites
- Java JDK 11 or higher
- Node.js and npm
- Appium Server
- Android SDK
- Android Studio
- IntelliJ IDEA or Eclipse
- Maven
## Installation Steps
1. Clone this repository:
    ```bash
    git clone https://github.com/al-amin3009/APIDemo_Appium.git
    cd APIDemo_Appium
    ```
2. Install dependencies:
    ```bash
    mvn clean install
    ```
## Running the Tests
1. Ensure the emulator or real device is active.
2. Run the AppTest Class

## Automation Strategy:

The project follows these key principles:

- **Page Object Model (POM)**: Each app screen is represented by a dedicated Page Object class, encapsulating UI elements and actions. This promotes code reusability, maintainability, and reduces reliance on fragile element locators.
- **TestNG**: Test cases are structured using TestNG annotations like @Test for clear organization and execution flow control.
- **Appium Client**: The Appium Java Client library interacts with the Android app under test, allowing us to find UI elements, perform actions, and verify results.

## Technical Implementations
#### 1. Dynamic Scrolling
- Uses UiScrollable and UiSelector for dynamic element location
- Implemented scrolling method to find elements dynamically

#### 2. Gesture Interactions

##### Long Press Gesture
- Uses JavascriptExecutor for mobile gestures
- Configurable duration for long press

##### Drag and Drop

- Implements mobile drag gesture
- Supports precise coordinate-based dropping

### Key Components
- **Base Page:** Contains common methods for interaction
- **Page Classes:** Represent individual app screens
- **Test Classes:** Define test scenarios
- **Utility Classes:** Provide supporting functions

### Logs
```
[Appium][0m Welcome to Appium v2.13.1
[38;5;112m[Appium][0m Non-default server args:
[38;5;112m[Appium][0m { address: [32m'127.0.0.1'[39m }
[38;5;112m[Appium][0m The autodetected Appium home path: C:\Users\Al-Amin\.appium
[38;5;112m[Appium][0m Attempting to load driver uiautomator2...
[38;5;112m[Appium][0m Requiring driver at C:\Users\Al-Amin\.appium\node_modules\appium-uiautomator2-driver\build\index.js
[38;5;112m[Appium][0m AndroidUiautomator2Driver has been successfully loaded in 1.316s
[38;5;86m[HTTP][0m Could not start REST http interface listener. The requested port may already be in use. Please make sure there is no other instance of this server running already.
[38;5;112m[Appium][0m Could not configure Appium server. It's possible that a driver or plugin tried to update the server and failed. Original error: listen EACCES: permission denied 127.0.0.1:4723
[38;5;112m[Appium][0m Error: listen EACCES: permission denied 127.0.0.1:4723
    at Server.setupListenHandle [as _listen2] (node:net:1881:21)
    at listenInCluster (node:net:1960:12)
    at node:net:2166:7
    at processTicksAndRejections (node:internal/process/task_queues:90:21)
PASSED: AppTest.AppTest.PopupMenu
        Navigate to Customa Adapter and perform Long press
PASSED: AppTest.AppTest.testDragAndDrop
        Perform Drag and Drop

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================
```
## Expected Output

### Scenario 1: Open the App
   -  The ApiDemos-debug.apk launches successfully on the device/emulator.

### Scenario 2: Navigate to the "Views" Section
   - The "Views" option is visible and selectable on the home screen.

### Scenario 3: Scroll to and Select "Expandable Lists"

- The "Expandable Lists" option is dynamically scrolled into view and selected.

### Scenario 4: Select "Custom Adapter"

   - The "Custom Adapter" option is selected successfully within "Expandable Lists".

### Scenario 5: Long Press an Item
-  The first item (e.g., "People Names") is long-pressed, and a contextual menu appears with options like "Sample action".

### Scenario 6: Navigate Back and Go to "Drag and Drop"

   - Successfully navigates back to the "Views" section and selects the "Drag and Drop" option.

### Scenario 7: Perform a Drag-and-Drop

   - The first circle is successfully dragged and dropped onto the second circle.

###  Validation and Assertions:

   - The contextual menu for "People Names" is displayed as expected.

   - The drag-and-drop operation results in visible UI changes or success messages.