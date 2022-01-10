package com.cybertek.tests.Week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
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
    @Test
    public void scrollTestJSE() throws InterruptedException {
        //first way
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        jse.executeScript("window.scroll(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        jse.executeScript("window.scroll(0,- document.body.scrollHeight)");
        Thread.sleep(1000);
        //second way
        WebElement cybertekschool=driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true)",cybertekschool);

    }
    /*HomeWork:
    This is real interview test
    HW: v.Test application www.IonicPartners.com:
vi. Test 1: Go to <Blog> page and scroll it down
vii. Test 2: Go to <About> page, scroll it down and click on Twitter icon at the bottom of the page
    * */
}
