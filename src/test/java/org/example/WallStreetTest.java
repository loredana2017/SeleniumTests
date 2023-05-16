package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WallStreetTest extends BrowserSetup {

    String xPathSearchButton = "//*[@id='menu-search']";
    String xPathSearchInput = "//input[@name='keyword']";

    String xPathSearchHeader = "//*[@class='complementary-container']//h1";

    String xPathSearchSubmitButton = "//*[@name='submit']";

    String xPathArticlesTitle = "//h3[@class='title']";

    String xPathSecondPage = "//a[text()='2']";

    @Test
    public void searchTest() {

        openURL("https://www.wall-street.ro");
        log("Test step 1");
        WebElement searchButton = findByXpath(xPathSearchButton);
        searchButton.click();
        wait(2000);
        WebElement searchInput = findByXpath(xPathSearchInput);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.attributeContains(searchInput, "placeholder", "cauta articole...")));

        log("Test step 2");
        WebElement xPathSearchInputClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathSearchInput)));
        xPathSearchInputClick.click();
        findByXpath(xPathSearchInput).sendKeys("casa verde");
        wait(2000);
        findByXpath(xPathSearchSubmitButton).sendKeys(Keys.ENTER);
        //emailField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        Assert.assertTrue(wait.until(ExpectedConditions.attributeContains(By.xpath(xPathSearchHeader), "innerText", "Cautare articole despre casa verde pe Wall-Street")));

        List<WebElement> titlesArticles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPathArticlesTitle)));
        for (WebElement element : titlesArticles) {
            System.out.println(element.getText());
        }
        System.out.println("______________________");
        findByXpath(xPathSecondPage).click();
        titlesArticles = wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPathArticlesTitle))));
        for (WebElement element : titlesArticles) {
            System.out.println(element.getText());
        }


    }
}
