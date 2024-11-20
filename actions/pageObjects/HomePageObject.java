package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    // Ham
    //1- Cung ten voi ten clas
    //2- Khong co DataType
    //3- Se dc chay dau tien khi class nay duoc goi
    //4- Co tham so hoac khong
    //5- Ko tu define ham khoi tao thi may ao java sex mac dinh tao ra ham khoi tao rong

    public void clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);

    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver,HomePageUI.LOGIN_BUTTON);
        clickToElement(driver,HomePageUI.LOGIN_BUTTON);
    }
}
