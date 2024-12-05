package com.nopcommerce.users;
import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_05a_ByPassCloudFlare extends BaseTest {
      WebDriver driver;


      @Parameters("browser")
      @BeforeClass
    public void beforeClass(String browserName) {
     driver =  getBrowserDriver(browserName);

 }

  @Test
    public void Register_01_Register_Empty_Data(){

     driver.get("https://demo.nopcommerce.com/");

    }


   @AfterClass
    public void afterClass()
    {
     //    driver.quit();

    }




}
