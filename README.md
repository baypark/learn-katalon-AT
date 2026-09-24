# SauceDemo Web Automation - Katalon Studio

## 📌 Project Description

This project contains an automated UI testing framework for **SauceDemo**
using **Katalon Studio**.

The purpose of this project is to demonstrate practical Software Quality
Assurance and UI automation capabilities, including:

- Functional UI testing
- Positive and negative test scenarios
- Edge case testing
- Dynamic element handling
- Explicit wait strategies
- Data-driven testing
- Basic programming logic
- Page-based Object Repository organization
- Test Suite execution
- Automated test reporting

The automation covers the main user journey:

**Login → Product → Cart → Checkout → Order Completion**

The project was created as part of a QA automation assessment.

---

# 📁 Project Structure

```text
Learning Katalon-AT Saucedemo/
│
├── Data Files/
│   └── Checkout_Data
│
├── Object Repository/
│   │
│   ├── Login_page/
│   │   ├── Username_input
│   │   ├── Password_input
│   │   ├── Login_button
│   │   └── Error_message
│   │
│   ├── Products_page/
│   │   ├── Products_title
│   │   ├── Add_to_cart_button
│   │   ├── Cart_badge
│   │   └── Cart_Icon
│   │
│   ├── Cart_page/
│   │   ├── Cart_title
│   │   ├── Cart_items
│   │   ├── Cart_item
│   │   └── Checkout_button
│   │
│   └── Checkout_page/
│       ├── Checkout_title
│       ├── First_name_input
│       ├── Last_name_input
│       ├── Postal_code_input
│       ├── Continue_button
│       ├── Checkout_error
│       ├── Overview_title
│       ├── Overview_item
│       ├── Finish_button
│       └── Success_message
│
├── Profiles/
│   └── default/
│       └── Global Variables
│
├── Test Cases/
│   ├── Login/
│   │   ├── TC_LOGIN_001_Valid_Login
│   │   └── TC_LOGIN_002_Invalid_Login
│   │
│   ├── Cart/
│   │   └── TC_CART_001_Add_Product
│   │
│   └── Checkout/
│       ├── TC_CHECKOUT_001_Missing_Information
│       └── TC_CHECKOUT_002_Successful_Checkout
│
├── Test Suites/
│   └── TS-SauceDemo-Regression
│
├── README.md
└── .gitignore

## ⚙️ Prerequisites

Before running the automation project, make sure the following are available:

Required
macOS / Windows
Java Runtime Environment compatible with Katalon Studio
Katalon Studio
Google Chrome
Git

Application Under Test
SauceDemo:

https://www.saucedemo.com/

# Test Credentials

The project uses the credentials defined in the test cases and/or Global
Variables.

Example:

| Username        | Password                       |
| --------------- | ------------------------------ |
| `standard_user` | secret_sauce                   |
| `problem_user`  | secret_sauce                   |

`Test credentials are intended for the SauceDemo test environment only.`

## 🛠️ Tech Stack

| Technology             | Purpose                    |
| ---------------------- | -------------------------- |
| Katalon Studio         | UI test automation         |
| Groovy                 | Test scripting             |
| Selenium WebDriver     | Browser automation engine  |
| Google Chrome          | Target browser             |
| XPath                  | Web element identification |


# Data-Driven Testing

Checkout data is maintained separately from the test script using Katalon Test Data.

Example:

|  FirstName          | LastName       | PostalCode   |
| ------------------- | ---------------| --------------
| Testing User        | new test       | 17530        |
| `Missing_First_Name`| last Name      | 17530        |


## 📊 Test Data

Test data is separated from test logic where appropriate.

Global Variables

The default execution profile contains reusable configuration values such as:

`BaseUrl`
`validUsername`
`validPassword`

These variables are used by multiple test cases.


## 🧪 Test Coverage

The project currently covers five core scenarios.

ID	Test Case	Type	Coverage
TC-LOGIN-001	Valid Login	Positive	Successful authentication
TC-LOGIN-002	Invalid Login	Negative	Invalid and locked credentials
TC-CART-001	Add Product	Positive	Add product and validate cart
TC-CHECKOUT-001	Missing Checkout Information	Negative / Validation	Required field validation
TC-CHECKOUT-002	Successful Checkout	Positive / E2E	Complete checkout flow


## 🧩 Test Suites
TS-SauceDemo-Regression

The main regression Test Suite contains the five core automated scenarios:

TS-SauceDemo-Regression
│
├── TC-LOGIN-001-Valid-Login
├── TC-LOGIN-002-Invalid-Login
├── TC-CART-001-Add-Product
├── TC-CHECKOUT-001-Missing-Checkout-Information
└── TC-CHECKOUT-002-Successful-Checkout

Each test case manages its own browser session to maintain test isolation.
The Test Suite provides a single execution point for validating the core SauceDemo flow


## ▶️ How to Run
`Option 1 - Run Individual Test Case`
- Open the project in Katalon Studio.
- Navigate to Test Cases.
- Select the desired test case.
- Select the Chrome execution profile.
- Click Run.

`Option 2 - Run Regression Test Suite`
- Open Katalon Studio.
- Navigate to Test Suites.
- OpenTS-SauceDemo-Regression
- Select the desired browser.
- Click Run.
- Review the execution result.

## 📈 Test Reporting

Katalon Studio provides execution results and test reports after the test
suite execution.

The report can be used to review:

- Passed test cases
- Failed test cases
- Execution duration
- Test step results
- Failure information
- Screenshots/execution evidence where available

The assessment requires the automation project to include evidence of the
Katalon Test Report or execution log.


## 👤 Author
---
Bayu Ahmad Prakoso | QA Engineer
