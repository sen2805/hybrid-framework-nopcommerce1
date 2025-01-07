package pageUIs.jquery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_LINK = "Xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME = "Xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW="XPATH=//td[@data-key='females' and text()='%s' ]" +
            "/following-sibling::td[@data-key='country' and text()='%s']" +
            "/following-sibling::td[@data-key='males' and text()='%s']" +
            "/following-sibling::td[@data-key='total' and text()='%s']  ";

    public static final String DYNAMIC_DELETE_BUTTON_BY_ROW ="XPATH=//td[@data-key='country'and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'remove')]";
    public static final String DYNAMIC_EDIT_BUTTON_BY_ROW ="XPATH=//td[@data-key='country'and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'edit')]";
    public static final String LOAD_DATA_BUTTON = "Xpath=//button[@id='load']";
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER = "XPATH=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "XPATH=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "XPATH=//td[%s]//select[@id='tblAppendGrid_country_%s']";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "XPATH=//tr[%s]/td[%s]//input[@type='checkbox']";
    public static final String DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX = "XPATH=//tr[%s]/td//button[starts-with(@title,'%s')]";

    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2= "XPATH=//div[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String ALL_VALUE_BY_COLUMN_INDEX="XPATH=//td[%s]";

    public static final String FILE_LOADED_BY_FILE_NAME = "XPath=//p[@class='name' and text()='%s']";
    public static final String UPLOAD_BUTTON = "Css=td>button.start";
    public static final String FILE_UPLOADED_SUCCESS_BY_FILE_NAME = "XPath=//p[@class='name']/a[@title='%s']";
}



























