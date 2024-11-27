package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage {
    private WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(how = How.CLASS_NAME, using = "ico-register")
    private WebElement registerLink;

    @FindBy(how = How.CLASS_NAME, using = "ico-account")
    private WebElement myAccountLink;

    @FindBy(how = How.CLASS_NAME, using = "ico-login")
    private WebElement loginButtonLink;


    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginButtonLink);
        clickToElement(loginButtonLink);

    }
    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver,myAccountLink);
        return isElementDisplayed(myAccountLink);
    }


}


