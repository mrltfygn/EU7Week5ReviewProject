package com.cybertek.tests.Week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {

    //action.moveToElement().perform()




    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    //What is TestNG? => Unit testing tool
    @Test
    public void moveToElementTest() throws InterruptedException {
        //Scroll down to Powered by the Cybertek
        Actions actions=new Actions(driver);
        //locate the element
        WebElement cybertekschool=driver.findElement(By.linkText("Cybertek School"));
        //scrolling to that element
        actions.moveToElement(cybertekschool).perform();
        Thread.sleep(2000);
        //advanced Keyboard actions
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }
}
