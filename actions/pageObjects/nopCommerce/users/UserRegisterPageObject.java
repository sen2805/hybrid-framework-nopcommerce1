package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopcommerce.users.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;
    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Male Radio")
    public void clickToMaleRadio() {
         waitForElementVisible(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
         checkToCheckboxRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to First Name textbox with value {0}")
    public void enterToFirstNameTextbox(String firstName) {
       waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }
    @Step("Enter to Last Name textbox with value {0}")

    public void enterToLastNameTextbox(String lastName) {
       waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }
    @Step("Enter to Email textbox with value {0}")

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    @Step("Enter to Company textbox with value {0}")

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX,companyName);
    }

    @Step("Enter to Password textbox with value {0}")
    public void enterToPasswordTextbox(String passWord) {
       waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,passWord);
    }

    @Step("Enter to Confirm textbox with value {0}")
    public void enterToConfirmPasswordTextbox(String confirmPassword) {
       waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Verify Register Success Message")
    public String getRegisterSuccessMessage() {
       waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
       return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Open Customer Ifo Page")
    public void openCustomerInfoPage() {
        waitForElementVisible(driver, UserRegisterPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserRegisterPageUI.MY_ACCOUNT_LINK);

    }
    @Step("Logout system")
    public UserHomePageObject logOutSystem() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Get Register Page Title")
    public String getRegisterPageTitle() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver,UserRegisterPageUI.REGISTER_PAGE_TITLE);

    }
}
