import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// =====================================================
// Test Data
// =====================================================

def checkoutData = findTestData('Checkout_Data')

String firstName = checkoutData.getValue('FirstName', 2)
String lastName = checkoutData.getValue('LastName', 2)
String postalCode = checkoutData.getValue('PostalCode', 2)

// 1. Open Browser
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.BaseUrl)

// 2. Login
WebUI.waitForElementVisible(
    findTestObject('Object Repository/Login_page/Username_input'),
    10
)

WebUI.setText(
    findTestObject('Object Repository/Login_page/Username_input'), 'standard_user')

WebUI.setText(
    findTestObject('Object Repository/Login_page/Password_input'),
    GlobalVariable.validPassword
)

WebUI.click(
    findTestObject('Object Repository/Login_page/Login_button')
)

WebUI.waitForElementVisible(
    findTestObject('Object Repository/Products_page/Products_title'),
    10
)

// 3. Add Product
String productName = 'Sauce Labs Backpack'

TestObject addButton = findTestObject(
    'Object Repository/Products_page/Add_to_cart_button',
    [('productName'): productName]
)

WebUI.waitForElementClickable(addButton, 10)
WebUI.click(addButton)

// Verify cart badge
WebUI.waitForElementVisible(
    findTestObject('Object Repository/Products_page/Cart_badge'),
    10
)

WebUI.verifyElementText(
    findTestObject('Object Repository/Products_page/Cart_badge'),
    '1'
)

// 4. Open Cart
WebUI.waitForElementClickable(
    findTestObject('Object Repository/Products_page/Cart_Icon'),
    10
)

WebUI.click(
    findTestObject('Object Repository/Products_page/Cart_Icon')
)

WebUI.waitForElementVisible(
    findTestObject('Object Repository/Cart_page/Cart_title'),
    10
)

// Verify product
TestObject cartItem = findTestObject(
    'Object Repository/Cart_page/Cart_item',
    [('productName'): productName]
)

WebUI.verifyElementPresent(cartItem, 10)

// 5. Checkout
WebUI.waitForElementClickable(
    findTestObject('Object Repository/Cart_page/Checkout_button'),
    10
)

WebUI.click(
    findTestObject('Object Repository/Cart_page/Checkout_button')
)

WebUI.waitForElementVisible(
    findTestObject('Object Repository/Checkout_page/Checkout_title'),
    10
)

// 6. Enter Checkout Data
WebUI.setText(
    findTestObject('Object Repository/Checkout_page/First_name_input'),
    firstName
)

WebUI.setText(
    findTestObject('Object Repository/Checkout_page/Last_name_input'),
    lastName
)

WebUI.setText(
    findTestObject('Object Repository/Checkout_page/Postal_code_input'),
    postalCode
)

// 7. Continue
WebUI.click(
    findTestObject('Object Repository/Checkout_page/Continue_button')
)

// 8. Verify Overview
WebUI.waitForElementVisible(
    findTestObject('Object Repository/Checkout_page/Overview_title'),
    10
)

TestObject overviewItem = findTestObject(
    'Object Repository/Checkout_page/Overview_item',
    [('productName'): productName]
)

WebUI.verifyElementPresent(overviewItem, 10)

// 9. Finish
WebUI.waitForElementClickable(findTestObject('Object Repository/Checkout_page/Finish_button'),10)

WebUI.click(findTestObject('Object Repository/Checkout_page/Finish_button'))

// 10. Verify Success
WebUI.waitForElementVisible(
    findTestObject('Object Repository/Checkout_page/Success_message'),
    10
)

WebUI.verifyElementPresent(
    findTestObject('Object Repository/Checkout_page/Success_message'),
    10
)

WebUI.closeBrowser()