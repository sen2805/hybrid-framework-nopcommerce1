package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public void clickToMaleRadio() {
         waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO);
         checkToCheckboxRadio(driver,RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
       waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
       waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver,RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.DAY_DROPDOWN,day);

    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver,RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.MONTH_DROPDOWN,month);

    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver,RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.YEAR_DROPDOWN,year);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver,RegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.COMPANY_NAME_TEXTBOX,companyName);
    }

    public void enterToPasswordTextbox(String passWord) {
       waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,passWord);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
       waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }


    public String getRegisterSuccessMessage() {
       waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
       return getElementText(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }


    public void clickToMyAccountLink() {
        waitForElementVisible(driver,RegisterPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,RegisterPageUI.MY_ACCOUNT_LINK);

    }
}
