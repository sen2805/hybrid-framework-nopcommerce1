package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    private WebDriver driver;
    public LoginPageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;



    public void enterToEmailTextbox(String emailAddress) {

        waitForElementVisible(driver,emailTextbox);
        sendKeyToElement(emailTextbox,emailAddress);
        
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendKeyToElement(passwordTextbox,password);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver,loginButton);
        clickToElement(loginButton);
    }

    public void loginToSystem(String emailAddress, String password) {
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();

    }
}
