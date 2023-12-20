# Platform Housing Project

## GitHub Repository - https://github.com/WSMaan/PlatformHousingProject

## Project Structure

- **base:** Initializes WebDriver instances based on the specified browser type.
- - **enums:**
  - `Browsers`: Enumerates the supported web browsers (CHROME, FIREFOX, EDGE).

- **pages:**
    - `LoginPage`: Represents login functionality.
    - `ProductPage`: Interacts with products, selects items, views the shopping basket, and proceeds to checkout.
    - `CheckoutStep1Page`: Users enter personal information during checkout.
    - `CheckoutStep2Page`: Checkout page to check item prices, tax payable, and complete the checkout process.
    - `OrderConfirmationPage`: Handles order confirmation and logout.

- **utility:** Configuration readers for user credentials, valid and invalid login details, and shipping information.

## Test Classes

### `TestBaseClass`

    - Provides a common base for initializing WebDriver instances.
    - Contains setup and teardown methods for test execution.

### `TestLoginPage`

    - Validates the login functionality with valid credentials.
    - Uses the `LoginPage` class for login actions.

### `TestProductPage`

     - Covers interactions with different products.
     - Used to test selecting items ,add to cart  and proceeding to checkout.

### `TestCheckoutStep1Page`

     - Tests the checkout step 1 where users enter personal information.
     - Uses the `CheckoutStep1Page` class for entering shipping details.

### `TestCheckoutStep2Page`

     - Tests the checkout step 2 for checking item prices and completing the checkout.
     - Verfies the prices and complete the checkout.

### `TestOrderConfirmationPage`

     - Validates order confirmation messages and navigation and log out.

### `TestFailedLogin`

     - Validates the login functionality with invalid credentials.

### `TestIntegrationPageClasses`

     - Integrates all tests for comprehensive testing.
     - Utilizes all page classes to cover end-to-end scenarios.

## Running Tests

### Before each test (`@BeforeTest`), change the browser type according to the requirement.

1. Open each test class.
2. Locate the `setUp()` method annotated with `@BeforeTest`.
3. Inside the `setUp()` method, change the browser type according to your requirement (FIREFOX, CHROME, or EDGE).


### Before running the tests,

**Note:** Make sure to update paths to browser executable files in the `browsers.properties` file.

### Individual Test Classes

1. Open your IDE and navigate to the test class you want to run.
2. Right-click on the class name.
3. Select "Run"

### TestNG XML Integration

    1. Open the `testng.xml` file.
    2. Run the TestNG XML file to execute the integration of all test classes.



   
