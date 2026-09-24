import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def invalidUsers = [
    [username: 'invalid_user', password: 'secret_sauce'],
    [username: 'standard_user', password: 'wrong_password'],
    [username: 'locked_out_user', password: 'secret_sauce']
]

WebUI.openBrowser('')

WebUI.maximizeWindow()

for (def credential : invalidUsers) {

// Reset to login page for each test data
WebUI.navigateToUrl(GlobalVariable.BaseUrl)

// Wait for login form
WebUI.waitForElementVisible(findTestObject('Object Repository/Login_Page/Username_Input'),3)
WebUI.waitForElementVisible(findTestObject('Object Repository/Login_Page/Password_Input'),3)

// Input username
WebUI.setText(findTestObject('Object Repository/Login_Page/Username_Input'),credential.username)

// Input password
WebUI.setText(findTestObject('Object Repository/Login_Page/Password_Input'),credential.password)

// Submit login
WebUI.click(findTestObject('Object Repository/Login_Page/Login_Button'))

// Verify error message
WebUI.waitForElementVisible(findTestObject('Object Repository/Login_Page/Error_Message'),3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/Error_Message'),3)

}

WebUI.closeBrowser()