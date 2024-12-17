package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserSideBarPageUI;

public class UserSidebarPageObject extends BasePage {
    WebDriver driver;
    public UserSidebarPageObject(WebDriver driver){
        this.driver=driver;
    }
    public UserRewardPointPageObject openRewardPointPage() {
        waitForElementClickable(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPageObject openCustomerInfoPage() {
        waitForElementClickable(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }


    public UserAddressPageObject openAddressPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSideBarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);

    }

    public UserOrderPageObject openOrderPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ORDER_LINK);
        clickToElement(driver, UserSideBarPageUI.ORDER_LINK);
        return  PageGenerator.getUserOrderPage(driver);
    }


}
