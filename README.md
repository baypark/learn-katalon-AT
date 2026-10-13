# saucedemo_web_automation_readme

# 🧪 SauceDemo Web Automation - Katalon Studio

An automated End-to-End (E2E) UI testing framework built with **Katalon Studio** for the SauceDemo web application. Designed to demonstrate industry-standard Quality Assurance (QA) practices and practical UI automation design patterns.

## 📌 Overview

This project showcases an automated testing suite designed to validate core e-commerce features, including positive/negative scenarios, edge cases, and data-driven validation.

### Key Highlights & Technical Capabilities

- **Design Pattern:** Modular Page-Based Object Repository organization.
- **Synchronization:** Explicit wait strategies and dynamic element handling.
- **Test Design:** Data-Driven Testing (DDT) using external datasets and global profiles.
- **Execution Strategy:** Isolated browser sessions per test case inside structured Test Suites.
- **Reporting:** Detailed test result reporting with automated execution logs and evidence capture.

### 🔄 End-to-End User Journey Covered

```
[ Login ] ➔ [ Product Catalog ] ➔ [ Shopping Cart ] ➔ [ Checkout Form ] ➔ [ Order Completion ]
```

## 🛠️ Tech Stack

| Technology | Purpose |
| --- | --- |
| **Katalon Studio** | Core Test Automation Framework |
| **Groovy / Java** | Test Scripting & Business Logic |
| **Selenium WebDriver** | Underlying Browser Automation Engine |
| **Google Chrome** | Target Execution Browser |
| **XPath / CSS** | Dynamic Web Element Identification |

## 📁 Project Structure

```
Learning Katalon-AT Saucedemo/
│
├── 📂 Data Files/
│   └── Checkout_Data                     # Data-driven test datasets
│
├── 📂 Object Repository/                 # Modular Page Objects
│   ├── 📁 Login_page/                    # Selectors for Login View
│   ├── 📁 Products_page/                 # Selectors for Catalog View
│   ├── 📁 Cart_page/                     # Selectors for Shopping Cart
│   └── 📁 Checkout_page/                 # Selectors for Checkout Flow
│
├── 📂 Profiles/
│   └── default/                          # Global Variables & Execution Environments
│
├── 📂 Test Cases/                        # Individual Automated Scenarios
│   ├── 📁 Login/
│   ├── 📁 Cart/
│   └── 📁 Checkout/
│
├── 📂 Test Suites/
│   └── TS-SauceDemo-Regression           # E2E Regression Test Suite
│
├── .gitignore
└── README.md
```

## 🧪 Test Scenarios & Coverage

The regression suite currently covers **5 high-priority core scenarios**:

| Scenario ID | Test Case | Test Type | Coverage Focus |
| --- | --- | --- | --- |
| **`TC-LOGIN-001`** | Valid Login | **Positive** | Successful user authentication |
| **`TC-LOGIN-002`** | Invalid Login | **Negative** | Invalid, empty, and locked-out user validation |
| **`TC-CART-001`** | Add Product | **Positive** | Product selection and dynamic cart badge update |
| **`TC-CHECKOUT-001`** | Missing Info | **Negative** | Form validation & mandatory field error handling |
| **`TC-CHECKOUT-002`** | Successful Checkout | **E2E** | Complete purchasing flow through order completion |

## 📊 Test Data & Execution Profiles

### 🔐 Test Credentials

The project utilizes configured credentials from test datasets and Global Variables.

| Username | Password | Purpose |
| --- | --- | --- |
| `standard_user` | `secret_sauce` | Valid standard flow execution |
| `problem_user` | `secret_sauce` | UI/UX error handling validation |

> ⚠️ *Note: Test credentials are intended strictly for the public SauceDemo sandbox environment.*
> 

### 📄 Data-Driven Testing (DDT)

Checkout scenarios dynamically inject data from external datasets (e.g., `Checkout_Data`):

| First Name | Last Name | Postal Code | Expected Result |
| --- | --- | --- | --- |
| `Testing User` | `New Test` | `17530` | Successful Navigation |
| `Missing_First_Name` | `Last Name` | `17530` | Trigger Validation Error |

## ⚙️ Prerequisites

Ensure you have the following installed before running the suite:

- **OS:** macOS or Windows
- **JDK:** Java Runtime Environment (compatible with Katalon Studio)
- **IDE:** Katalon Studio
- **Browser:** Google Chrome (Latest Version)
- **VCS:** Git

## ▶️ Execution Guide

### Option 1: Run an Individual Test Case

1. Launch **Katalon Studio** and open this project directory.
2. Navigate to **Test Cases** in the *Tests Explorer* side panel.
3. Select any test case (e.g., `Test Cases/Login/TC_LOGIN_001_Valid_Login`).
4. Select **Chrome** from the top execution toolbar dropdown.
5. Click **Run** (`Ctrl + R` / `Cmd + R`).

### Option 2: Execute Full Regression Test Suite

1. In the *Tests Explorer*, open `Test Suites/TS-SauceDemo-Regression`.
2. Ensure target browser is set to **Chrome**.
3. Click **Run** to execute all 5 scenarios sequentially.
4. Review execution logs and real-time pass/fail status in the *Job Progress* tab.

## 📈 Test Execution & Reporting

Upon completion of a Test Suite run, Katalon Studio generates comprehensive test execution reports containing:

- ✅ **Pass / Fail Summary & Execution Duration**
- 📝 **Step-by-step Log Details**
- 📸 **Automated Screenshots on Failure Evidence**
- 📊 **Exportable Formats:** HTML, PDF, CSV, or JUnit XML

## 👤 Author

**Bayu Ahmad Prakoso - QA Engineer**
