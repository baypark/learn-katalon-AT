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

// Test Data

def checkoutData = findTestData('Checkout_Data')

String lastName = checkoutData.getValue('LastName', 1)
String postalCode = checkoutData.getValue('PostalCode', 1)

// Open browser
WebUI.openBrowser('')

// Navigate to SauceDemo
WebUI.navigateToUrl(GlobalVariable.BaseUrl)


// Login
WebUI.waitForElementVisible(
	findTestObject('Object Repository/Login_page/Username_input'),
	10
)

WebUI.setText(findTestObject('Object Repository/Login_page/Username_input'),'standard_user')

WebUI.setText(
	findTestObject('Object Repository/Login_page/Password_input'),
	GlobalVariable.validPassword
)

WebUI.click(
	findTestObject('Object Repository/Login_page/Login_button')
)

// Add Backpack
String productName = 'Sauce Labs Backpack'

TestObject addButton = findTestObject(
	'Object Repository/Products_page/Add_to_cart_button',
	[('productName'): productName]
)

WebUI.waitForElementClickable(addButton, 10)
WebUI.click(addButton)


// Open Cart
WebUI.waitForElementClickable(
	findTestObject('Object Repository/Products_page/Cart_icon'),
	10
)

WebUI.click(
	findTestObject('Object Repository/Products_page/Cart_icon')
)

// Checkout
WebUI.waitForElementVisible(
	findTestObject('Object Repository/Cart_page/Cart_title'),
	10
)

WebUI.waitForElementClickable(
	findTestObject('Object Repository/Cart_page/Checkout_button'),
	10
)

WebUI.click(
	findTestObject('Object Repository/Cart_page/Checkout_button')
)

// Checkout Information
WebUI.waitForElementVisible(
	findTestObject('Object Repository/Checkout_page/Checkout_title'),
	10
)

// First Name intentionally left EMPTY
WebUI.setText(
    findTestObject('Object Repository/Checkout_page/Last_name_input'),
    lastName
)

WebUI.setText(
    findTestObject('Object Repository/Checkout_page/Postal_code_input'),
    postalCode
)

// Continue
WebUI.click(
	findTestObject('Object Repository/Checkout_page/Continue_button')
)

// Verify validation error
WebUI.waitForElementVisible(
	findTestObject('Object Repository/Checkout_page/Checkout_error'),
	10
)

WebUI.verifyElementPresent(
	findTestObject('Object Repository/Checkout_page/Checkout_error'),
	10
)

// User should remain on Checkout Information page
WebUI.verifyElementPresent(
	findTestObject('Object Repository/Checkout_page/Checkout_title'),
	10
)

WebUI.closeBrowser()