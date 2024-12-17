package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_09b_Check_URL {
    @Test
    @Parameters({"userUrl", "adminUrl"})
    public void testURLs(String userUrl, String adminUrl) {
        // Sử dụng các tham số userUrl và adminUrl trong các bước kiểm thử của bạn
        System.out.println("User URL: " + userUrl);
        System.out.println("Admin URL: " + adminUrl);

        // Giả sử bạn đang sử dụng Selenium WebDriver để điều hướng đến các URL này
        WebDriver driver = new FirefoxDriver();
        driver.get(userUrl);  // Điều hướng đến user URL
        driver.get(adminUrl); // Điều hướng đến admin URL
    }

}
