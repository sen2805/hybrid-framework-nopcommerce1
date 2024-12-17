package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.get("http://localhost/");
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

}
