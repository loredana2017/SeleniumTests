package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class MainClicking {


    public static WebDriver driver;
    public static String xPathElements = "//h5[text()='Elements']";
    public static String xPathCheckBox = "//*[@class ='text'][text() ='Check Box']";
    public static String xPathPlusButton = "//button[@aria-label = 'Expand all']";
    public static String idDoubleClick = "doubleClickBtn";
    public static String idDoubleClickMessage = "doubleClickMessage";
    public static String idRightClick = "rightClickBtn";
    public static String idRightClickMessage = "rightClickMessage";
    public static String xpathSimpleClick = "//button[text()='Click Me']";

    public static void main(String[] args) throws InterruptedException {
        browserSetUp();
        openURL("https://demoqa.com/buttons");
        wait(1000);
        WebElement doubleClickButton = findElementByID(idDoubleClick);
        clickByAction(doubleClickButton, "doubleClick");
        wait(1000);
        WebElement doubleClickMessage = findElementByID(idDoubleClickMessage);
        System.out.println(doubleClickMessage.getText());

        WebElement rightClickButton = findElementByID(idRightClick);
        clickByAction(rightClickButton, "rightClick");
        wait(1000);
        WebElement rightClickMessage = findElementByID(idRightClickMessage);
        System.out.println(rightClickMessage.getText());

        quitBrowser();
    }

    public static void browserSetUp() {
        log("Setting up Chrome browser.");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
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

    public static void quitBrowser() {
        log("Closing Chrome browser.");
        driver.quit();
    }

    public static void openURL(String url) {
        log("Opening URL: " + url);
        driver.get(url);
    }

    public static void log(String login) {
        System.out.println(login);
    }

    public static void wait(int millis) throws InterruptedException {
        log(String.format("Waiting for %d millis.", millis));
        Thread.sleep(millis);
    }

}