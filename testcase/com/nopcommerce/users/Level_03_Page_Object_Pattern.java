package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_Page_Object_Pattern  extends BaseTest {
    //Declare  Variable
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;


    //Pre-Condition
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("http://localhost/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         // Khởi tạo HomePage được sinh ra và bắt đầu làm những action của page đó
        homePage = new HomePageObject(driver);
        firstName = "Sen";
        lastName = "Pham";
        day = "22" ;
        month = "September";
        year = "2024";
        emailAddress = "sen" + generateRandomNumber() + "@gmail.com";
        password = "123456";
        companyName = "Klooon" ;




    }

    //Testcases
    @Test
    public void User_01_Register() throws InterruptedException {
        // Action 1
        homePage.clickToRegisterLink();
        // HomePage qua Register page - RegisterPage được sinh ra và làm những action của page đó
        registerPage = new RegisterPageObject(driver);
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        Thread.sleep(3000);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
       // registerPage.clickToLogoutLink();
        registerPage.clickToMyAccountLink();


    }
    @Test
    public  void User_02_MyAccount(){
        customerInfoPage = new CustomerInfoPageObject(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
    //    Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
      //  Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
       // Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
         customerInfoPage.clickToLogOutLink();

    }
    @Test
    public void User_03_Login(){
        homePage = new HomePageObject(driver);
        homePage.clickToLoginButton();
        loginPage = new LoginPageObject(driver);
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        homePage = new HomePageObject(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    //Post-Condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }



}