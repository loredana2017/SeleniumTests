package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class StartupApp {

    @BeforeSuite()
    public void beforeSuite() {
        System.out.println(" > BeforeSuite < ");
    }
    @AfterSuite()
    public void afterSuite() {
        System.out.println(" > AfterSuite < ");
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
    }

    @AfterMethod()
    public void afterMethod(){
        System.out.println(" > AfterMethod <");
    }

}