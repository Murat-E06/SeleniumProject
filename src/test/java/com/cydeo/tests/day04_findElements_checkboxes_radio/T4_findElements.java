package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {
    public static void main(String[] args) {
        //TC #4: FindElements Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        //3- Locate all the links in the page.
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));//shortcut hoverower erroorline
        // intellij give advice us to create local var. or alt+enter->enter again

        //4- Print out the number of the links on the page.
        System.out.println("allLinks.size() = " + allLinks.size());//allLinks.size().soutv

        //5- Print out the texts of the links.
        //6- Print out the HREF attribute values of the links
        for (WebElement each : allLinks) {//allLink.ater or allLink.for
            System.out.println("Text of link: " + each.getText());//returns string by getText()
            System.out.println("HREF Values: "+each.getAttribute("href"));//returns value
        }

    }
}
