package com.cydeo.tests.day06_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #1: Information alert practice
        //1. Open browser
         driver= WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }
    @Test
    public void alert_test1() throws InterruptedException {
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();
        Thread.sleep(1000);
        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert=driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));
        //Failure message will only be displayed if assertion fails:"Result text is NOT displayed"
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed");//burada assert in içi
        //true ol.için message yazmıyor (false olsaydı yazacaktı)sadece Total tests run: 1, Passes: 1, Failures: 0, Skips: 0 ifadesi çıkıyor

        String expectedText="You successfully clicked an alert";
        String actualText=resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual result test is not as expected!!!");

    }

}
