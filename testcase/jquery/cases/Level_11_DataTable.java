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

public class Level_11_DataTable extends BaseTest {

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);

    }

    public void Table_01()  {
        // Navigate to any page/Paging
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActived("15"));
        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageNumberActived("5"));
        homePage.openPageByNumber("10");
        Assert.assertTrue(homePage.isPageNumberActived("10"));

    }


    public void Table_02_Search() throws InterruptedException {
        homePage.enterToTextByHeaderName("Country","Afghanistan" );
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("384187","Afghanistan","407124","791312"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextByHeaderName("Males","12599691");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("12253515","AFRICA","12599691","24853148"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextByHeaderName("Females","777");

        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("777","Antigua and Barbuda","803","1580"));
        homePage.refreshCurrentPage(driver);

    }

    public void Table_03_Delete_Edit()  {
        // Tim ra 1 key (column) duy  nhat trong table - key cua column tu do dung gia tri nay de den duoc cac action mong muon
        homePage.enterToTextByHeaderName("Country","Afghanistan" );
        homePage.sleepInSeconds(3);
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextByHeaderName("Country","AFRICA" );
        homePage.editRowByCountryName("AFRICA");
        homePage.sleepInSeconds(3);
    }
    @Test
    public void Table_04_Get_All_Value_Row_Or_Column()  {
        homePage.getAllValueAtColumnName("Country");

    }


    public void Table_05_Action_By_Index()  {
        homePage.openPageURL(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickToLoadDataButton();
        homePage.sleepInSeconds(3);
        //Co the thao tac voi bat cu  1 column nao/row nao
     //   homePage.enterToTextBoxByIndex("4","Contact Person","Michael Jackson");
     //   homePage.sleepInSeconds(3);
     //   homePage.enterToTextBoxByIndex("4","Order Placed","881");
      //  homePage.sleepInSeconds(3);
      //  homePage.enterToTextBoxByIndex("2","Company","MJ Company");
      // homePage.sleepInSeconds(3);
      //  homePage.selectToDropdownByIndex("7","Country", "Hong Kong");
      //  homePage.sleepInSeconds(3);
    ///  homePage.selectToDropdownByIndex("8","Country", "Malaysia");
     //  homePage.sleepInSeconds(3);

   //   homePage.checkToCheckboxByIndex("6","NPO?",true);
   //   homePage.sleepInSeconds(3);
   //   homePage.checkToCheckboxByIndex("5","NPO?",false);
     // homePage.sleepInSeconds(3);

        homePage.clickToIconByIndex("4","Insert");
        homePage.clickToIconByIndex("8","Move Up");
       homePage.clickToIconByIndex("6","Remove");
        homePage.clickToIconByIndex("4","Insert");
    }







    @AfterClass
    public void afterClass(){
        driver.quit();

    }

    private WebDriver driver;
    private HomePO homePage;


}
