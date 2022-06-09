package com.cydeo.tests.day06_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T2_Alert_Practice_Confirmation {
    //TC #2: Confirmation alert practice

    WebDriver driver;

    @BeforeMethod
    public void factoryMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alertTest2() {
        //3. Click to “Click for JS Confirm” button
        WebElement JSConfirmButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        //burada gettext() syntax ını kullandı her ne kadar xpath dese de text mesajı uzun olan yerlede ayırt edici olabildiği için olabilir diye düşnyorum
        JSConfirmButton.click();

        //4. Click to OK button from the alert
        //to be able to click Alert OK button we need to switch driver's focus to Alert area
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));

        String expectedText="You clicked: Ok";
        String actualText=resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual result test is not as expected!!!");
        //"Actual result test is not as expected!!!" bu default ol. yazılıyor ki hata verirse buradan farkedilsin diye!!


    }
    @AfterMethod
    public void tearDrop(){
        driver.quit();
    }

}
