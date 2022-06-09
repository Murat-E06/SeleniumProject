package com.cydeo.tests.day02_LocatorsGetTextGetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {

        //TC#3: Google search
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com ");

        //3- Write “apple” in search box
        //4- PRESS UNTER using Keys.ENTER instead of Click google search button
        WebElement googleSearchBox=driver.findElement(By.name("q"));//yukarıdaki siteye gittik incele>ter imi zerine geldik kod alanında
        //higlight olan yerde name"q" den q yu copy/paste yaptık buraya(this locator finds the search box
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);//google search box a apple yaz ve enter a bas

        //5- Verify title:
        //Expected: Title should start with “apple” word
        String expectedInTitle="apple";//arama motorunda apple arattık ve en üstte title bölümünde apple yazıyor!!
        String actualTitle=driver.getTitle();

        if(actualTitle.startsWith(expectedInTitle)){
            System.out.println("Title verification PASS!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }





    }
}
