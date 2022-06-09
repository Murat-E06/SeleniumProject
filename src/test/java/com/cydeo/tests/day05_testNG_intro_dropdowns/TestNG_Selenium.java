package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    @BeforeMethod
    public void setupMethod(){

    }

    @Test
    public void selenium_test(){
        //Do browser driver setup
        //Open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //Max. page
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Get: "https://google.com"
        driver.get("https://google.com");

        //Assert:title is "Google"

        String actualTitle=driver.getTitle();
        String expectedTitle="Google";

        Assert.assertEquals(actualTitle,expectedTitle,"Title is not matching here.");


    }
}
