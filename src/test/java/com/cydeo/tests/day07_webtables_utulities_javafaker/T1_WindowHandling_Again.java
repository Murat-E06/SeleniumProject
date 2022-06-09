package com.cydeo.tests.day07_webtables_utulities_javafaker;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T1_WindowHandling_Again extends TestBase{
 /*
    ****Aşağıdaki açılış seramonisi yerine yukarıdaki class name e extend TestBase yazdık ve bu açılış
 ceramonisini oradan çağırdık***!!!

  public WebDriver driver;
    // 1. Create new test and make set ups

    @BeforeMethod

    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
  */


    //2. Go to : https://www.amazon.com

    @Test
    public void windowHandlingTest() {
        driver.get("https://www.amazon.com");//****buraya bir for each loop koyalım Josh***
        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            String currentURL = driver.getCurrentUrl();
            if (currentURL.contains("etsy")) {
                break;
            }
        }
        //5. Assert: Title contains “Etsy”
        String expectedTitle = "Etsy";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }

}
