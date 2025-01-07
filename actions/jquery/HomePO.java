package jquery;

import commons.BasePage;
import org.checkerframework.common.value.qual.EnsuresMinLenIf;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;
    public HomePO(WebDriver driver){
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
       waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK,pageNumber);
       clickToElement(driver,HomePageUI.DYNAMIC_PAGE_LINK,pageNumber);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_PAGE_LINK,pageNumber);
        return getElementAttribute(driver,HomePageUI.DYNAMIC_PAGE_LINK,"class",pageNumber).endsWith("active");

    }

    public void enterToTextByHeaderName(String headerName, String valueToSendkey) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME,headerName);
        sendKeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME,valueToSendkey,headerName);
        pressKeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER,headerName);

    }

    public boolean isRowDataValueDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_DATA_ROW,female,country,male,total);
        return isElementDisplayed(driver,HomePageUI.DYNAMIC_DATA_ROW,female,country,male,total);
    }

    public void deleteRowByCountryName(String countryName){
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_ROW,countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_ROW,countryName);
        sleepInSeconds(2);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_ROW,countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_ROW,countryName);
        sleepInSeconds(2);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);

    }

    public void enterToTextBoxByIndex(String roundIndex, String columnName, String valueToSendkey) {
        //Tu column name lam sao lay dc column Index
        int columnIndexNumber = getListElement(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,columnName).size()+1;

        //Convert no qua dang text
        String columnIndex = String.valueOf(columnIndexNumber);
        //Truyen 2  gia tri rowIndex/columnIndex vao locator de tuong tac va sendkey
        sendKeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX,valueToSendkey,roundIndex,columnIndex);

    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        //Tu column name lam sao lay dc column Index
        int columnIndexNumber = getListElement(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,columnName).size()+1;

        //Convert no qua dang text
        String columnIndex = String.valueOf(columnIndexNumber);
        //Truyen 2 gia tri
        selectItemInDropdown(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX,valueToSelect,columnIndex,rowIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck  ) {
        int columnIndexNumber = getListElement(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,columnName).size()+1;
        String columnIndex = String.valueOf(columnIndexNumber);
        if(checkOrUncheck){
            checkToCheckboxRadio(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);

        } else  {
            uncheckToCheckbox(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX,rowIndex,iconName);
      clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX,rowIndex,iconName);
    }
    public List<String> getAllValueAtColumnName(String columnName) {
        //Dau tien phai lay dc Index cua column do
        int columnIndexNumber = getListElement(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2,columnName).size()+1;

        //Convert no qua dang text
        String columnIndex = String.valueOf(columnIndexNumber);
        List<WebElement> allElementValueAtColumn =  getListElement(driver,HomePageUI.ALL_VALUE_BY_COLUMN_INDEX,columnName);
        List<String> allTextValue = new ArrayList<String>();
        for (WebElement element:allElementValueAtColumn ){
            allTextValue.add(element.getText()) ;
        }
        return allTextValue;

        
    }
}
