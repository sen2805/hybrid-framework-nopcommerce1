package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.BasePageUI;
import pageUIs.RewardPointPageUI;
import pageUIs.SideBarPageUI;

public class SidebarPageObject extends BasePage {
    WebDriver driver;
    public SidebarPageObject(WebDriver driver){
        this.driver=driver;
    }
    public RewardPointPageObject openRewardPointPage() {
        waitForElementClickable(driver, SideBarPageUI.REWARD_POINT_LINK);
        clickToElement(driver,SideBarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPointPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForElementClickable(driver,SideBarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver,SideBarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerPage(driver);
    }


    public AddressPageObject openAddressPage() {
        waitForElementClickable(driver, SideBarPageUI.ADDRESS_LINK);
        clickToElement(driver, SideBarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);

    }

    public OrderPageObject openOrderPage() {
        waitForElementClickable(driver, SideBarPageUI.ORDER_LINK);
        clickToElement(driver,SideBarPageUI.ORDER_LINK);
        return  PageGenerator.getOrderPage(driver);
    }


}
