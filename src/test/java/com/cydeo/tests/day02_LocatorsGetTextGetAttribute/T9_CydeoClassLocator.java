package com.cydeo.tests.day02_LocatorsGetTextGetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T9_CydeoClassLocator {
    public static void main(String[] args) {
        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        WebElement homeLink=driver.findElement(By.linkText("Home"));
        homeLink.click();

        //4- Verify title is as expected:
        //Expected: Practice
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED!");
        }else{
            System.out.println("Title verification is FAILED!!!");
        }



    }
}
