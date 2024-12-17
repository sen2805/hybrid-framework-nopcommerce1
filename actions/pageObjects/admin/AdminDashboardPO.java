package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminDashboardPO extends BasePage {
    WebDriver driver;
    public AdminDashboardPO(WebDriver driver){
        this.driver=driver;
    }
}
