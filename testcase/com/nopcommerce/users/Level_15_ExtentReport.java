package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.users.*;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

//import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.method;
//import pageObjects.users.*;

public class Level_15_ExtentReport extends BaseTest {
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
    public void User_01_Register(Method method)  {

        // Action 1
       ExtentManager.startTest(method.getName(), "TC_01_NewCustomer");
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 01: Open Register Page");
        registerPage = homePage.openRegisterPage();
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 03: Enter To FirstName textbox with value" +firstName);
        registerPage.enterToFirstNameTextbox(firstName);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 04: Enter To Lastname textbox with value" +lastName);
        registerPage.enterToLastNameTextbox(lastName);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 05: Enter To Email Address textbox with value" +emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 06: Enter To Company textbox with value" +companyName);
        registerPage.enterToCompanyTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 07: Enter To password with value" +password);
        registerPage.enterToPasswordTextbox(password);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 08: Enter To Confirm password with value" +password);
        registerPage.enterToConfirmPasswordTextbox(password);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 09: Click button Login");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 10: Verify msg: Your registration completed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed..");

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 11: Open Page Customer Info");
        registerPage.openCustomerInfoPage();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 12:Logout system");
        registerPage.logOutSystem();
    }

    @Test
    public void User_02_Login(Method method){
        ExtentManager.startTest(method.getName(), "TC_01_NewCustomer");
        loginPage = homePage.openLoginPage(driver);
        homePage = loginPage.loginToSystem(emailAddress,password);
        PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public  void User_03_MyAccount(Method method){
        ExtentManager.startTest(method.getName(), "TC_02_My Account");
        customerInfoPage = homePage.openCustomInfoPage(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }



}
