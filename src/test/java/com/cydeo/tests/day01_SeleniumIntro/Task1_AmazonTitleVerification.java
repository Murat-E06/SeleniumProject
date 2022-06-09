package com.cydeo.tests.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_AmazonTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        //System.out.println("driver.getTitle() = " + driver.getTitle());//driver.getTitle() = Amazon.com. Spend less. Smile more.

        String expectedTitle="Amazon.com. Spend less. Smile more.";

        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.equals(expectedTitle)){
            System.out.println( "Title is as expected. Verification PASSED");
        }else {
            System.out.println( "Title is NOT as expected. Verification FAILED");
        }

        
        


    }
}
