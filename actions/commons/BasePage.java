package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageObjects.nopCommerce.users.UserAddressPageObject;
import pageObjects.nopCommerce.users.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.users.UserOrderPageObject;
import pageObjects.nopCommerce.users.UserRewardPointPageObject;
//import pageObjects.users.*;
import pageUIs.jquery.HomePageUI;
import pageUIs.nopcommerce.BasePageUI;
import pageUIs.nopcommerce.users.UserHomePageUI;
import pageUIs.nopcommerce.users.UserSideBarPageUI;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BasePage {

    public static commons.BasePage getBasePage(){
        return new commons.BasePage();
    }

    //Action: click/open/sendkeys/...> void
    public  void openPageURL(WebDriver driver, String pageURL){
        driver.get(pageURL);
    }

    //Verify: getTitle/getURL/text/attribute/css/display
    public String getPageTitle(WebDriver driver){
        return  driver.getTitle();
    }

    public String getPageURL(WebDriver driver){
        return driver.getCurrentUrl();
    }


    public String pageSourceCode(WebDriver driver){
        return  driver.getPageSource();

    }
    public  void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver){
         return  new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver){

        waitAlertPresence(driver).accept();
    }


    public void cancelAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
    }

    public void senKeyToAlert(WebDriver driver,String keysToSend){
        waitAlertPresence(driver).sendKeys(keysToSend);
    }

    public String getAlertText(WebDriver driver){
       return waitAlertPresence(driver).getText();
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public  WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }
    public List<WebElement> getListElement(WebDriver driver, String locator,String ...restParameter){
        return driver.findElements(getByLocator(castParameter(locator,restParameter)));
    }


    public By getByXPath(String locator){
        return By.xpath(locator);
    }
    private String castParameter(String locator, String ...restParameter){

        return String.format(locator,(Object[]) restParameter);
    }

    public By getByLocator(String prefixLocator){
        By by = null;
        if (prefixLocator.startsWith("ID")||prefixLocator.startsWith("id")||prefixLocator.startsWith("Id")){
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.startsWith("class")||prefixLocator.startsWith("CLASS")||prefixLocator.startsWith("Class")){
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.startsWith("name")||prefixLocator.startsWith("Name")||prefixLocator.startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.startsWith("tagname")||prefixLocator.startsWith("Tagname")||prefixLocator.startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if(prefixLocator.startsWith("css")||prefixLocator.startsWith("Css")||prefixLocator.startsWith("CSS")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if(prefixLocator.startsWith("xpath")||prefixLocator.startsWith("XPATH")||prefixLocator.startsWith("Xpath")
                ||prefixLocator.startsWith("XPath")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator Type is not support");
        }
        System.out.println(by);
        return by;

      }


    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
    }
    //Sua tai day
    public void clickToElement(WebDriver driver, String locator,String ...value){
        getElement(driver,castParameter(locator,value)).click();
    }


    public void clickToElementByAction(WebDriver driver, String locator){
        new Actions(driver).click(getElement(driver,locator)).perform();
    }

    public void clickAndHoldToElement (WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElement(driver,locator)).perform();
    }



    public void releaseLeftMouse (WebDriver driver){
        new Actions(driver).release();
    }


    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend){
        getElement(driver,locator).clear();
        getElement(driver,locator).sendKeys(keyToSend);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueToSendkey,String ...restParameter){
        getElement(driver,castParameter(locator,restParameter)).clear();
        getElement(driver,castParameter(locator,restParameter)).sendKeys(valueToSendkey);
    }
    public void selectItemInDropdown(WebDriver driver,String locator,String textItem,String ...restParameter){
        new Select(getElement(driver,castParameter(locator,restParameter))).selectByVisibleText(textItem);
    }
    public void selectItemInDropdown(WebDriver driver,String locator,String textItem ){
         new Select(getElement(driver,locator)).selectByVisibleText(textItem);
    }
    public String getSelectedItemInDropdown(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).getFirstSelectedOption().getText();

    }

    public boolean isDropdownMultiple(WebDriver driver,String locator){
        return new Select(getElement(driver,locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem){
        getElement(driver,parentLocator).click();
        sleepInSeconds(2);
        List<WebElement> allItems = new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSeconds(2);
        for (WebElement item : allItems){
            if(item.getText().trim().equals(expectedItem)){
                item.click();
                break;
            }
        }
    }
    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getElementAttribute(WebDriver driver, String locator,String attributeName){
       return  getElement(driver,locator).getAttribute(attributeName);
    }
    public String getElementAttribute(WebDriver driver, String locator,String attributeName, String ...restParameter){
        return  getElement(driver,castParameter(locator,restParameter)).getAttribute(attributeName);
    }
    public String  getElementText(WebDriver driver, String locator){
        return getElement(driver,locator).getText();
    }
    public String  getElementText(WebDriver driver, String locator,String ...restParameter){
        return getElement(driver,castParameter(locator,restParameter)).getText();
    }
    public  String getCSSValue(WebDriver driver, String locator, String propertyName){
        return getElement(driver,locator).getCssValue(propertyName);
    }

    public  String getHexColorFromRGBA(String rgbaName){
        return Color.fromString(rgbaName).asHex().toUpperCase();
    }

   public void getListElementNumber(WebDriver driver, String locator){
        getListElement(driver,locator).size();
   }

   public void checkToCheckboxRadio(WebDriver driver, String locator){
       if(!getElement(driver,locator).isSelected()){
           getElement(driver,locator).click();
       }
   }
    public void checkToCheckboxRadio(WebDriver driver, String locator, String ...restParameter){
        if(!getElement(driver,castParameter(locator,restParameter)).isSelected()){
            getElement(driver,castParameter(locator,restParameter)).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator){
        if(getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }
    public void uncheckToCheckbox(WebDriver driver, String locator, String ...restParameter){
        if(getElement(driver,castParameter(locator,restParameter)).isSelected()){
            getElement(driver,castParameter(locator,restParameter)).click();
        }
    }
    public boolean isElementDisplayed(WebDriver driver, String locator){
        return  getElement(driver,locator).isDisplayed();

    }
    public boolean isElementDisplayed(WebDriver driver, String locator,String ...restParameter){
        return  getElement(driver,castParameter(locator,restParameter)).isDisplayed();

    }


    public boolean isElementEnable(WebDriver driver, String locator){
        return  getElement(driver,locator).isEnabled();

    }
    public boolean isElementSelected(WebDriver driver, String locator,String ...restParameter){
        return  getElement(driver,castParameter(locator,restParameter)).isSelected();

    }


    public boolean isElementSelected(WebDriver driver, String locator){
        return  getElement(driver,locator).isSelected();

    }

    public void switchToIframe(WebDriver driver,String locator){
        driver.switchTo().frame(getElement(driver,locator));
    }

    public void switchToDefaultPage(WebDriver driver){
        driver.switchTo().defaultContent();
    }



    public void hoverToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator ){
        new Actions(driver).dragAndDrop(getElement(driver,sourceLocator), getElement(driver,targetLocator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElement(driver,locator), keys).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys,String ...restParameter){
        new Actions(driver).sendKeys(getElement(driver,castParameter(locator,restParameter)), keys).perform();
    }

    public void scrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getElement(driver,locator)).perform();
    }


    public void highLightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String ...restParameter){
         new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementPresence(WebDriver driver, String locator,String ...restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }


    public void waitForElementInvisible(WebDriver driver, String locator, String ...restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }
    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String ...restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String ...restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator,restParameter))));
    }

    public void uploadMultipleFiles(WebDriver driver, String ...fileNames){
        //Lay ra duong dan cua thu muc Upload File
        String filePath =  GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        // Dung vong lap duyet qua cac file name
        for (String file : fileNames){
            fullFileName +=  filePath + file + "\n";
        }

        //trim: cat ki tu xuong dong (\n) o 2 dau chuoi di
        fullFileName =fullFileName.trim();
        getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);


    }

    public boolean isFileLoadedByName(WebDriver driver,String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME,fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME,fileName);
    }


    public void clickToUploadButton(WebDriver driver) {
         List<WebElement> startButtons =getListElement(driver,HomePageUI.UPLOAD_BUTTON);
         for (WebElement button :startButtons){
             button.click();
             sleepInSeconds(3);
         }

    }


    public boolean isFileUpLoadedByName(WebDriver driver,String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME,fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME,fileName);
    }





    public UserCustomerInfoPageObject openAccountPage(WebDriver driver) {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }



    public UserCustomerInfoPageObject openCustomInfoPage(WebDriver driver) {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }
    public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }


    public UserAddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSideBarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);

    }

    public UserOrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarPageUI.ORDER_LINK);
        clickToElement(driver, UserSideBarPageUI.ORDER_LINK);
        return  PageGenerator.getUserOrderPage(driver);
    }


}
