package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
         return  new WebDriverWait(driver, Duration.ofSeconds(15))
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
        return driver.findElement(getByXPath(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(getByXPath(locator));
    }

      public By getByXPath(String locator){
        return By.xpath(locator);
      }


    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
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
        List<WebElement> allItems = new WebDriverWait(driver,Duration.ofSeconds(15))
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
    public String  getElementText(WebDriver driver, String locator){
        return getElement(driver,locator).getText();
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

    public void uncheckToCheckbox(WebDriver driver, String locator){
        if(getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }
    public boolean isElementDisplayed(WebDriver driver, String locator){
        return  getElement(driver,locator).isDisplayed();

    }

    public boolean isElementEnable(WebDriver driver, String locator){
        return  getElement(driver,locator).isEnabled();

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

    public void waitForElementVisible(WebDriver driver, String locator){
         new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(getByXPath(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(getByXPath(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(getByXPath(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeSelected(getByXPath(locator)));
    }












}
