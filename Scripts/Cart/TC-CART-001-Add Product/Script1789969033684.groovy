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


WebUI.openBrowser('')

//WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.BaseUrl)


// Login
WebUI.waitForElementVisible(
	findTestObject('Object Repository/Login_page/Username_input'),
	10
)

WebUI.setText(
	findTestObject('Object Repository/Login_page/Username_input'),
	'standard_user'
)

WebUI.setText(
	findTestObject('Object Repository/Login_page/Password_input'),
	'secret_sauce'
)

WebUI.click(
	findTestObject('Object Repository/Login_page/Login_button')
)

// Verify Products page
WebUI.waitForElementVisible(
	findTestObject('Object Repository/Products_page/Products_title'),
	10
)

// Dynamic product
String productName = 'Sauce Labs Backpack'

TestObject addButton = findTestObject(
	'Object Repository/Products_page/Add_to_cart_button',
	[('productName'): productName]
)

// Wait & Add product
WebUI.waitForElementClickable(addButton, 10)
WebUI.click(addButton)

// Dynamic element cart update
WebUI.waitForElementVisible(
	findTestObject('Object Repository/Products_page/Cart_badge'),
	10
)

WebUI.verifyElementText(
	findTestObject('Object Repository/Products_page/Cart_badge'),
	'1'
)

// Open cart
WebUI.click(
	findTestObject('Object Repository/Products_page/Cart_icon')
)

WebUI.waitForElementVisible(
	findTestObject('Object Repository/Cart_page/Cart_title'),
	10
)

// Verify product on cart
TestObject cartItem = findTestObject(
	'Object Repository/Cart_page/Cart_item',
	[('productName'): productName]
)

// Count actual cart items
def cartItems = WebUI.findWebElements(
    findTestObject('Object Repository/Cart_page/Cart_item_count'),
    10
)

println("Number of cart elements = " + cartItems.size())

cartItems.eachWithIndex { item, index ->
    println("Cart item ${index + 1}: " + item.getText())
}

WebUI.verifyEqual(cartItems.size(), 1)
WebUI.verifyElementPresent(cartItem, 10)

WebUI.closeBrowser()