package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RewardPointPageUI;

public class RewardPointPageObject extends BasePage {
    private WebDriver driver;
    public RewardPointPageObject(WebDriver driver) {
        this.driver = driver;
    }


}
