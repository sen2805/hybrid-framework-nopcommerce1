package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopcommerce.users.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;
    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Register Page")
    public UserRegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
       return PageGenerator.getUserRegisterPage(driver);

    }

    @Step("Verify My Account Link is displayed")
    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    @Step("User Login Page")
    public UserLoginPageObject openLoginPage(WebDriver driver) {
        waitForElementVisible(driver, UserHomePageUI.LOGIN_BUTTON);
        clickToElement(driver, UserHomePageUI.LOGIN_BUTTON);
        return PageGenerator.getUserLoginPage(driver);

    }

}
