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

public class Level_13_Verify extends BaseTest {
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

        registerPage = homePage.openRegisterPage();
        //Fail 01
        verifyEquals(registerPage.getRegisterPageTitle(),"REGISTER");

        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        //Fail 02
        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed!!!");
        registerPage.openCustomerInfoPage();
        registerPage.logOutSystem();
    }

    @Test
    public void User_02_Login(){
        loginPage = homePage.openLoginPage(driver);
        homePage = loginPage.loginToSystem(emailAddress,password);
        PageGenerator.getUserHomePage(driver);
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public  void User_03_MyAccount(){
        customerInfoPage = homePage.openCustomInfoPage(driver);
        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        verifyEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        verifyEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        verifyEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }



}
