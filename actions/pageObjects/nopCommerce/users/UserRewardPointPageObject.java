package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserRewardPointPageObject extends UserSidebarPageObject {
    private WebDriver driver;

    public UserRewardPointPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
