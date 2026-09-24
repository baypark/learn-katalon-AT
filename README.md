# SauceDemo Katalon Automation


## Project Structure

```Learning Katalon-AT Saucedemo
Profiles/
Test Cases/
Object Repository/
Data Files/
Test Suites/
Reports/
README.md


## Scope

Automated SauceDemo scenarios using Katalon Studio.

## Test Coverage

| ID | Scenario | Type |
|---|---|---|
| TC-LOGIN-001 | Valid Login | Positive |
| TC-LOGIN-002 | Invalid Login | Negative |
| TC-CART-001 | Add Product | Positive |
| TC-CHECKOUT-001 | Missing Checkout Information | Negative |
| TC-CHECKOUT-002 | Successful Checkout | Positive |

## Automation Coverage

- Page-based Object Repository
- Dynamic Test Object
- Explicit element waits
- Katalon Test Data
- Loop-based validation
- Positive and negative scenarios
- End-to-end checkout flow

## Execution

Test Suite:
`TS-SauceDemo-Regression`

The regression suite contains:

- TC-LOGIN-001-Valid Login
- TC-LOGIN-002-Invalid Login
- TC-CART-001-Add Product
- TC-CHECKOUT-001-Missing Checkout Information
- TC-CHECKOUT-002-Order Created


## Test Data
Checkout test data is maintained separately in:

`Data Files/Checkout_Data`

Example:
FirstName	LastName	PostalCode
Backpack	Bayu	QA	17530


## Synchronization Strategy

The automation uses Katalon explicit waits:

- waitForElementVisible
- waitForElementClickable
- waitForPageLoad

`No hard-coded Thread.sleep() or WebUI.delay() is used.`


## Browser Configuration

Chrome password leak detection is disabled for the automation browser through Katalon Chrome preferences to prevent the Chrome password warning from interrupting automated execution. Normal Chrome security settings remain unchanged.

## Reporting

Katalon execution results and test reports are generated after executing the test suite.

## Notes

Test scenarios and automation implementation are based on the provided SauceDemo QA assessment requirements.