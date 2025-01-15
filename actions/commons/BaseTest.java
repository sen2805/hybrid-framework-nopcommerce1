package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {

    private WebDriver driver;


    protected WebDriver getBrowserDriver(String browserName){

        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case EDGE:
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(GlobalConstants.DEV_USER_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    protected WebDriver getBrowserDriver(String browserName,String url){

        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case EDGE:
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }


    protected int generateRandomNumber(){
        return new Random().nextInt(9999);
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try {
            Assert.assertTrue(condition);
        }catch (Throwable  e){
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyFalse(boolean condition){
        boolean status = true;
        try {
            Assert.assertFalse(condition);
        }catch (Throwable  e){
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyEquals(Object actual, Object expected ){
        boolean status = true;
        try {
            Assert.assertEquals(actual,expected);
        }catch (Throwable  e){
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;

    }



}
