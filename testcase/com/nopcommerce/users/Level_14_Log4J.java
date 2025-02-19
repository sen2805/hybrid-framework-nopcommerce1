package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.users.*;
//import pageObjects.users.*;

public class Level_14_Log4J extends BaseTest {
    //Declare  Variable
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    private UserCustomerInfoPageObject customerInfoPage;
    private UserAddressPageObject addressPage;
    private UserOrderPageObject orderPage;
    private UserRewardPointPageObject rewardPointPage;

    private String firstName, lastName, emailAddress, companyName, password;

    @Parameters("browser")
    //Pre-Condition
    @BeforeClass
    public void beforeClass(String browserName){
        driver =  getBrowserDriver(browserName);
        homePage = PageGenerator.getUserHomePage(driver);
        firstName = "Sen";
        lastName = "Pham";
        emailAddress = "sen" + generateRandomNumber() + "@gmail.com";
        password = "123456";
        companyName = "Kloon" ;
    }

    //Testcases
    @Test
    public void User_01_Register()  {
        // Action 1
        log.info("User_01_Register - STEP 01: Open Register Page");
        registerPage = homePage.openRegisterPage();

        log.info("User_01_Register - STEP 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register - STEP 03: Enter To FirstName textbox with value" +firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("User_01_Register - STEP 04: Enter To Lastname textbox with value" +lastName);
        registerPage.enterToLastNameTextbox(lastName);

        log.info("User_01_Register - STEP 05: Enter To Email Address textbox with value" +emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_01_Register - STEP 06: Enter To Company textbox with value" +companyName);
        registerPage.enterToCompanyTextbox(companyName);

        log.info("User_01_Register - STEP 07: Enter To password with value" +password);
        registerPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - STEP 08: Enter To Confirm password with value" +password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("User_01_Register - STEP 09: Click button Login");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - STEP 10: Verify msg: Your registration completed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed..");

        log.info("User_01_Register - STEP 11: Open Page Customer Info");
        registerPage.openCustomerInfoPage();

        log.info("User_01_Register - STEP 12:Logout system");
        registerPage.logOutSystem();
    }

    @Test
    public void User_02_Login(){
        loginPage = homePage.openLoginPage(driver);
        homePage = loginPage.loginToSystem(emailAddress,password);
        PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public  void User_03_MyAccount(){
        customerInfoPage = homePage.openCustomInfoPage(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
    }
    @Test
    public void User_04_Dynamic_Page(){
        //Customer Infor -> Address
        addressPage = (UserAddressPageObject) customerInfoPage.openSidebarLinkByPageName("Addresses");
        // Addresses page -> Reward Point
        rewardPointPage = (UserRewardPointPageObject) addressPage.openSidebarLinkByPageName("Reward points");
        //Reward Point  -> Order
        orderPage = (UserOrderPageObject) rewardPointPage.openSidebarLinkByPageName("Orders");
        //Order -> Addresses
        addressPage = (UserAddressPageObject) orderPage.openSidebarLinkByPageName("Addresses");
        //Address -> Customer Infor
        customerInfoPage = (UserCustomerInfoPageObject) addressPage.openSidebarLinkByPageName("Customer info");
        rewardPointPage = (UserRewardPointPageObject) customerInfoPage.openSidebarLinkByPageName("Reward points");
        addressPage = (UserAddressPageObject) rewardPointPage.openSidebarLinkByPageName("Addresses");
    }
    @Test
    public void User_05_Dynamic_Page(){
        // AddressPage -> Reward point
        addressPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);
        //Reward point -> Orders
        rewardPointPage.openSidebarLinkByPageNames("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);
        //Orders -> Addresses page
        orderPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);
    }


    @AfterClass
    public void afterClass(){
        driver.quit();

    }



}
