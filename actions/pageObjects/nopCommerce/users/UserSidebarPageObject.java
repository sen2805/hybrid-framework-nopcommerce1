package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopcommerce.users.UserSideBarPageUI;

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
    public UserSidebarPageObject openSidebarLinkByPageName(String pageName){
        waitForElementClickable(driver,UserSideBarPageUI.DYNAMIC_LINK_PAGE_NAME,pageName);
        clickToElement(driver,UserSideBarPageUI.DYNAMIC_LINK_PAGE_NAME,pageName);
        switch (pageName){
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPointPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            default:
                throw new RuntimeException("Page name is not valid") ;
        }
    }

    public void openSidebarLinkByPageNames(String pageName){
        waitForElementClickable(driver,UserSideBarPageUI.DYNAMIC_LINK_PAGE_NAME,pageName);
        clickToElement(driver,UserSideBarPageUI.DYNAMIC_LINK_PAGE_NAME,pageName);

    }



}
