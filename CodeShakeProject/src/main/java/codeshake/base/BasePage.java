package codeshake.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10, 400);
    }

    public WebElement find(By locator) {
        return webDriver.findElement(locator);
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void waitUntilElementIsNotVisible(By by){

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

    public void waitUntilElementIsVisible(By by){

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public WebElement findElement(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getValueAttribute(By by) {
        return findElement(by).getAttribute("value");

    }

    public void switchFrame(WebElement element) {

        webDriver.switchTo().frame(element);

    }

    public void click(By by) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement element = findElement(by);
        element.click();

    }

    public void sendKeys(By by, CharSequence text) {

        WebElement element = findElement(by);
        element.clear();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);

    }

    public void sleep(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void scrollToElement(By by) {
        sleep(2);
        WebElement element = webDriver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        sleep(1);
    }

    public  String[] getWords(String address) {

        address  = address.replaceAll(",", "").replaceAll("/", " ");
        String[] words = address.split(" ");

        return words;
    }

    public void sameWordsofTwoAddresses(String[] words1, String[] words2) {

        System.out.print("Same words of 2 addresses : ");

        for (int i = 0; i < words1.length; i++) {
            for (int k = 0; k < words2.length; k++) {
                if (words1[i].equals(words2[k])) {
                    System.out.print(words1[i] +" ");
                }
            }
        }
    }
}
