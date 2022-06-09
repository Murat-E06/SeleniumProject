package com.cydeo.tests.day06_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_window_test(){

        //Storing the main page's window handle as string good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);//CDwindow-2A06AC99E9175E3A4CB6CF965282399E seklinde uniqe bir
        //kod üretilir!! her yeni açılan sayfada!!

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title before click: " + actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        //burada 4. locator olan linkText i kullandık it gives first matching it works only links

        clickHereLink.click();

        //6. Switch to new Window.
        Set<String> allWindowHandles = driver.getWindowHandles();
        // window handle 1 - main window
        // window handle 2 - 2nd window

        for(String each: allWindowHandles){
            //burada 2 window var fakat daha fazla pencere açılırsa şayet en güzel cozum each loop
            //bunun için de yukarıda allWindowsHandles diye bir ArrayList tanımladı

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());

        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitleAfterClick);

        System.out.println("Title after click: " + actualTitle);

        //If we want to go back to main page, we can use already stored main handle
        //driver.switchTo().window(mainHandle);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();//close everyting but driver.close close last one
    }

}
