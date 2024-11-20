package com.nopcommerce.users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_01_Register_DRY {
      WebDriver driver;
      String emailAddress;


 @BeforeClass
    public void beforeClass() {
       driver = new FirefoxDriver();
       emailAddress = "sentest" + generateRandomNumber() + "@gmail.com";
       //Selenium 3.x
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       //Selenium 4.x
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       driver.get("http://localhost/");


    }

  @Test
    public void Register_01_Register_Empty_Data(){
            driver.findElement(By.xpath("//a[@class='ico-register']")).click();
            driver.findElement(By.xpath("//button[@id='register-button']")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(),"First name is required.");
            Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(),"Last name is required.");
            Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(),"Email is required.");
            Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(),"Password is required.");
    }


   @AfterClass
    public void afterClass()
    {
         driver.quit();

    }
    public int generateRandomNumber(){
       return new Random().nextInt(9999);
    }



}
