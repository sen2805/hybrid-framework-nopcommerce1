package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.*;
//import pageObjects.users.*;

public class PageGenerator {
    public static UserHomePageObject getUserHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserCustomerPage(WebDriver driver){
        return  new UserCustomerInfoPageObject(driver);
    }
    public static UserAddressPageObject getUserAddressPage(WebDriver driver){
        return new UserAddressPageObject(driver);
    }
    public static UserOrderPageObject getUserOrderPage(WebDriver driver){
        return new UserOrderPageObject(driver);
    }
    public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver){
        return new UserRewardPointPageObject(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return  new AdminDashboardPO(driver);
    }
    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return  new AdminLoginPO(driver);
    }





}
