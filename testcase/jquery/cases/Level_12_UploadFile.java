package jquery.cases;

import commons.BaseTest;
import jquery.HomePO;
import jquery.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_12_UploadFile extends BaseTest {

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);
        hue = "Hue.jpg";
        hoian= "HoiAn.jpg";
        hanoi = "HaNoi.jpg";

    }

    @Test
    public void Upload_01()  {
        //Lay ra dc duong dan cua file thu muc cho dung
        //Lay tat ca OS: Window/MAC/Linux deu chay dc
        //Co the upload 1 lan 1 file => dung 1 ham
       // homePage.uploadMultipleFiles(driver,hue);
      //  homePage.sleepInSeconds(3);
       // homePage.refreshCurrentPage(driver);
        //Co the upload 1 lan nhieu file => dung 1 ham
       // homePage.uploadMultipleFiles(driver,hoian,hanoi);
       // homePage.sleepInSeconds(3);
      //  homePage.refreshCurrentPage(driver);

        //Co the verify 1 file / nhieu file => dung 1 ham
        homePage.uploadMultipleFiles(driver,hue,hoian,hanoi);
        homePage.sleepInSeconds(3);
     //   homePage.refreshCurrentPage(driver);
        //Verify load file len
        Assert.assertTrue(homePage.isFileLoadedByName(driver,hue));
        Assert.assertTrue(homePage.isFileLoadedByName(driver,hoian));
        Assert.assertTrue(homePage.isFileLoadedByName(driver,hanoi));
        //Click upload button tai tung file
        homePage.clickToUploadButton(driver);
        //Co the verify 1 file/ nhieu file da upload thanh cong
        Assert.assertTrue(homePage.isFileUpLoadedByName(driver,hue));
        Assert.assertTrue(homePage.isFileUpLoadedByName(driver,hoian));
        Assert.assertTrue(homePage.isFileUpLoadedByName(driver,hanoi));




    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }

    private WebDriver driver;
    private HomePO homePage;
    private String hue, hoian, hanoi;


}
