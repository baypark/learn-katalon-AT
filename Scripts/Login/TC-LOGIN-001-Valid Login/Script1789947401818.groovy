import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.BaseUrl)

WebUI.waitForElementVisible(findTestObject('Object Repository/Login_page/Username_Input'), 10)

WebUI.setText(findTestObject('Object Repository/Login_page/Username_input'),'standard_user')

WebUI.setText(findTestObject('Object Repository/Login_page/Password_Input'), GlobalVariable.validPassword)

WebUI.click(findTestObject('Object Repository/Login_page/Login_button'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Products_page/Products_title'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Products_page/Products_title'), 'Products')

WebUI.waitForElementVisible(findTestObject('Object Repository/Products_page/Cart_icon'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Products_page/Cart_icon'), 10)

WebUI.closeBrowser()