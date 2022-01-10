package com.cybertek.tests.Week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsAndIframeTest {
    //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    //2. Switch to iframe.
    //3. Double click on the text “Double-click me to change my text color.”
    //4. Assert: Text’s “style” attribute value contains “red”.
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1() {
        //switch to iframe
        WebElement frameElement = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frameElement);
        //locate to element
        WebElement textToDoubleClick = driver.findElement(By.id("demo"));
        // for double click we need actions object
        Actions actions = new Actions(driver);
        //action and perforn
        actions.doubleClick(textToDoubleClick).perform();
        // Assert text
        String expectedResult = "red";
        String actualResult = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
