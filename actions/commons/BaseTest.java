package commons;

import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.commons.logging.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import zmq.socket.pubsub.Pub;

import java.time.Duration;
import java.util.Random;

public class BaseTest {

    protected WebDriver driver;
    protected final Logger log;

    public WebDriver getDriver() {
        return driver;
    }


    // Log4j Version 1
    /*
    public BaseTest(){
        log = LogFactory.getLog(getClass());

    }*/

    //Log4j for version2
    public BaseTest(){
        log =  LogManager.getLogger(getClass());

    }

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
            log.info("-----PASSED---------");
        }catch (Throwable  e){
            status = false;
            log.info("-----FAILED---------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyFalse(boolean condition){
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("-----PASSED---------");
        }catch (Throwable  e){
            status = false;
            log.info("-----FAILED---------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyEquals(Object actual, Object expected ){
        boolean status = true;
        try {
            Assert.assertEquals(actual,expected);
            log.info("-----PASSED---------");
        }catch (Throwable  e){
            status = false;
            log.info("-----FAILED---------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;

    }



}
