package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserSetup {

    static WebDriver driver;
    String URL = "https://energie.gov.ro/";

    @BeforeSuite()
    public void beforeSuite() {
        System.out.println(" > BeforeSuite < ");
        browserSetUp();
    }
    @AfterSuite()
    public void afterSuite() {
        System.out.println(" > AfterSuite < ");
        quitBrowser();
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println(" > BeforeTest < ");
    }
    @AfterTest
    public void afterTest() {
        System.out.println(" > AfterTest < ");
    }
    @BeforeGroups
    public void beforeGroups() {
        System.out.println(" > BeforeGroups < ");
    }
    @AfterGroups
    public void afterGroups() {
        System.out.println(" > AfterGroups < ");
    }

    @BeforeMethod()
    public void beforeMethod(){
        System.out.println(" > BeforeMethod <");
        openURL(URL);
    }

    @AfterMethod()
    public void afterMethod(){
        System.out.println(" > AfterMethod <");
        wait(1000);
    }

    public void quitBrowser() {
        log("Closing Chrome browser.");
        driver.quit();
    }

    public void openURL(String url) {
        log("Opening URL: " + url);
        driver.get(url);
    }

    public WebElement findByXpath(String xpath) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            System.out.println("Elementul nu a fost gasit.");
        }

        return element;
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void wait(int millis) {
        log(String.format("Waiting for %d millis.", millis));

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void browserSetUp() {
        log("Setting up Chrome browser.");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.default_content_setting_values.cookies", 2);


//        Map<String, String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "iPhone SE");
//        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        // Adding capabilities to ChromeOptions
        //options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--disable-notifications");
        options.addArguments("--kiosk");
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        System.out.println(driver.manage().timeouts().getImplicitWaitTimeout());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

    }

}