package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPageObject;

public class Level_09_Switch_Site_URL extends BaseTest {
    //Declare  Variable
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private String firstName, lastName,  emailAddress, companyName, password;
    private String userUrl,adminUrl;
    private String adminEmailAddress, adminPassword;

    @Parameters({"browser","userUrl","adminUrl"})
    //Pre-Condition
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl){
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;
        driver =  getBrowserDriver(browserName,this.userUrl);
        userHomePage = PageGenerator.getUserHomePage(driver);
        firstName = "Sen";
        lastName = "Pham";
        emailAddress = "sen" + generateRandomNumber() + "@gmail.com";
        password = "123456";
        companyName = "Kloon" ;
        adminEmailAddress = "phamsen2805@gmail.com";
        adminPassword ="123456";
        userRegisterPage = userHomePage.openRegisterPage();
        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
         userRegisterPage.openCustomerInfoPage();
         userHomePage = userRegisterPage.logOutSystem();
    }
    @Test
    public void Role_01_User_Site_To_Admin_Site()  {
        userLoginPage = userHomePage.openLoginPage(driver);
        userHomePage = userLoginPage.loginToSystem(emailAddress,password);
        PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
        userHomePage.openPageURL(driver,this.adminUrl);
        //Chua login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminDashboardPage =PageGenerator.getAdminDashboardPage(driver);
        //Login vao trang Admin
        adminLoginPage.enterToEmailTextbox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

    }

    @Test
    public void Role_02_Admin_Site_To_User_Site(){
        //Vao trang Order/ Customer
        adminDashboardPage.openPageURL(driver,this.userUrl);
        userHomePage = PageGenerator.getUserHomePage(driver);
    }

    @AfterClass
    public void afterClass(){
       // driver.quit();

    }



}
