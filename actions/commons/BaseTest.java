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
    protected void initBrowser(){
      //  ChromeOptions chromeOptions = new ChromeOptions();
       //  chromeOptions.addArguments("--user-data-dir=C:/Users/admin/AppData/Local/Google/Chrome/User Data/");
      //  chromeOptions.addArguments("--profile-directory=Profile 3");
      //  driver = new ChromeDriver(chromeOptions);

         EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir = C:/Users/admin/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 9");
        driver = new EdgeDriver(edgeOptions);

    }

    protected WebDriver getBrowserDriver(String browserName){
        initBrowser();
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }


    protected WebDriver getBrowserDriver1111(String browserName){
        initBrowser();
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case EDGE:
                driver = new EdgeDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }



    protected int generateRandomNumber(){
        return new Random().nextInt(9999);
    }

}
