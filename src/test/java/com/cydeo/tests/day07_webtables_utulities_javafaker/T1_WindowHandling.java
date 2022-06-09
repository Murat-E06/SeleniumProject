package com.cydeo.tests.day07_webtables_utulities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void window_handling_test(){
        //2. Go to: https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy-paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        //yukarıda downcasting var amazona ilave olarak bu 3 siteyi de acti!!

        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String>allWindowsHandles=driver.getWindowHandles();//Handles olunca ArrayList in içine atabiliyoruz
        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("current URL: "+driver.getCurrentUrl());
            //current URL: https://www.amazon.com/
            //current URL: https://www.facebook.com/
            //current URL: https://www.etsy.com/
            //current URL: https://www.google.com/

            if(driver.getCurrentUrl().contains("etsy")){
                break;//etsy den sonra çıkar google a geçemez!!
            }
        }
        //5.Assert:Title contains "Etsy"
        String actualTitle=driver.getTitle();
        String expectedTitle="Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));//kontrol!! contains de ilave edilebiliyor!!


    }
}
