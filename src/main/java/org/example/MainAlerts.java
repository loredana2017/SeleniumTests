package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class MainAlerts {


    public static WebDriver driver;
    public static String alertID = "alertButton";
    public static String confirmAlertID = "confirmButton";
    public static String confirmAlertResultID = "confirmResult";

    public static void main(String[] args) throws InterruptedException {
        browserSetUp();
        openURL("https://demoqa.com/alerts");
        wait(1000);

        WebElement alertElement = findElementByID(alertID);

        if (alertElement.getDomProperty("disabled").equalsIgnoreCase("false")) {
            alertElement.click();
        }

        Alert myAlert = driver.switchTo().alert();
        log(myAlert.getText());
        wait(1000);
        myAlert.accept();
        wait(1000);

        findElementByID(confirmAlertID).click();
        Alert myConfirmAlert = driver.switchTo().alert();
        log(myConfirmAlert.getText());
        wait(1000);
        myAlert.dismiss();
        wait(1000);
        WebElement messageElement = findElementByID(confirmAlertResultID);
        log(messageElement.getText());

        quitBrowser();
    }

    public static void browserSetUp() {
        log("Setting up Chrome browser.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebElement findElementByXpath(String xPath) {
        log("Trying to find: " + xPath);
        return driver.findElement(By.xpath(xPath));
    }

    public static WebElement findElementByID(String id) {
        log("Trying to find: " + id);
        return driver.findElement(By.id(id));
    }

    public static void clickByJS(WebElement element) {
        log("Clicking by JavaScript: " + element.getText());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Do click by Actions API.
     *
     *
     * @param element web element
     * @param typeOfClick doubleClick / oneClick / rightClick
     */
    public static void clickByAction(WebElement element, String typeOfClick) {
        log("Clicking by Actions lib. on : " + element.getText());
        Actions actions = new Actions(driver);
        if (typeOfClick.equalsIgnoreCase("doubleClick")) {
            actions.moveToElement(element).doubleClick().build().perform();
        } else if (typeOfClick.equalsIgnoreCase("oneClick")) {
            actions.moveToElement(element).click().build().perform();
        } else if (typeOfClick.equalsIgnoreCase("rightClick")) {
            actions.moveToElement(element).contextClick().build().perform();
        }
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        log("Moving : " + source.getText() + " to " + target.getText());
        Actions actions = new Actions(driver);
        actions
                .moveToElement(source)
                .clickAndHold()
                .pause(1000)
                .moveToElement(target)
                .pause(3000)
                .release()
                .build()
                .perform();
        //actions.dragAndDrop(source, target).build().perform();
    }

    public static void quitBrowser() {
        log("Closing Chrome browser.");
        driver.quit();
    }

    public static void openURL(String url) {
        log("Opening URL: " + url);
        driver.get(url);
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void wait(int millis) throws InterruptedException {
        log(String.format("Waiting for %d millis.", millis));
        Thread.sleep(millis);
    }

}