package org.example;

import org.example.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestNGSelenium extends BrowserSetup {

    int a = 5;
    int b = 5;
    int sum = 10;
    String text = "I have two apples.";
    String wordToTest = "apple";

    @Test(description = "Test_S1", groups = "selenium-tests")
    public void testPageTitle1() {
        System.out.println("Test_S1 header 1");
        WebElement header = findByXpath("//*[@class='main-header']");
        Assert.assertEquals(header.getText(), "Elements", "Wrong text found in header");
    }

    @Test(description = "Test_S2", groups = "selenium-test")
    public void testPageTitle2() {
        System.out.println("Test_S2 header 2");
        WebElement header = driver.findElement(By.xpath("//*[@class='main-header']"));
        Assert.assertEquals(header.getText(), "Elements");
    }

    @Test(description = "Test_S3", groups = "selenium-test")
    public void testPageEGOV() {
        System.out.println("Test_S3 E GOV");
        WebElement searchField = driver.findElement(By.xpath("//input[@class='search']"));

        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));

        searchField.sendKeys("DAMADADC");
        wait(555);
        searchButton.click();

        By searchResults = By.xpath("//*[@class='entry-title']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        boolean result = wait.until(ExpectedConditions.attributeContains(searchResults, "textContent", "Fara rezultate"));
        List<WebElement> home = driver.findElements(By.id("menu-item-27645"));
        System.out.println("home mobile: " + home.get(0).isDisplayed());
        System.out.println("home web: " +home.get(1).isDisplayed());

    }

    //*[@id="menu-item-27467"]/amenu-item-27467

    //*[@class='element-group']//*[contains(text(), 'Interaction')]
    //*[@class='text'][contains(text(), 'Droppable')]
    //id="draggable"
    //id="droppable"

}