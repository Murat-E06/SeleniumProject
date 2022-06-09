package com.cydeo.tests.day08_propoties_config_reader;

import com.cydeo.utilities.ConfigurationsReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {

 //  public WebDriver driver;

    //   @BeforeMethod
    //  public void setupMethod() {

    //     String browserType= ConfigurationsReader.getProperty("browser");
    //     driver=WebDriverFactory.getDriver(browserType);

    //    driver = WebDriverFactory.getDriver(browserType);
    //    driver.manage().window().maximize();
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // }

    @Test
    public void google_search_test() {
        //TC #4: Google search
        //1- Open a chrome browser
        //2- Go to: https://google.com

        //Driver.getDriver()-->driver

        Driver.getDriver().get("https://www.google.com");
        //3- Write “apple” in search box
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        googleSearchBox.sendKeys(ConfigurationsReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle=ConfigurationsReader.getProperty("searchValue")+" - Google Search";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
