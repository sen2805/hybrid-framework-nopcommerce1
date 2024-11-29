package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.OrderPageUI;

public class OrderPageObject extends BasePage {
    private WebDriver driver;
    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
