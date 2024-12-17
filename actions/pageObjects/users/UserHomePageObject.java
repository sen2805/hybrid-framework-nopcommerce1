package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;
    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
       return PageGenerator.getUserRegisterPage(driver);

    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }
    public UserLoginPageObject openLoginPage(WebDriver driver) {
        waitForElementVisible(driver, UserHomePageUI.LOGIN_BUTTON);
        clickToElement(driver, UserHomePageUI.LOGIN_BUTTON);
        return PageGenerator.getUserLoginPage(driver);

    }

}
