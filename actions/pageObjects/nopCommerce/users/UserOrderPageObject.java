package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserOrderPageObject extends UserSidebarPageObject {
    private WebDriver driver;
    public UserOrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
