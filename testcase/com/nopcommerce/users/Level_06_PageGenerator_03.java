package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.users.UserCustomerInfoPageObject;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPageObject;

public class Level_06_PageGenerator_03 extends BaseTest {
    //Declare  Variable
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private String firstName, lastName,  emailAddress, companyName, password;

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
        companyName = "Klooon" ;
    }

    //Testcases
    @Test
    public void User_01_Register()  {
        // Action 1
        registerPage = homePage.openRegisterPage();
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
        registerPage.openCustomerInfoPage();


    }
    @Test
    public  void User_02_MyAccount(){
        customerInfoPage = new UserCustomerInfoPageObject(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
         customerInfoPage.clickToLogOutLink();

    }

    public void User_03_Login(){
       // homePage = new HomePageObject(driver);
        loginPage = homePage.openLoginPage(driver);
        loginPage = new UserLoginPageObject(driver);
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        homePage = new UserHomePageObject(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_04_Login(){

        loginPage = homePage.openLoginPage(driver);
        homePage = loginPage.loginToSystem(emailAddress,password);

      //  homePage = new HomePageObject(driver);
        PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    //Post-Condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }



}
