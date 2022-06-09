package com.cydeo.tests.day02_LocatorsGetTextGetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {
    public static void main(String[] args) {

        //TC #2: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //3- Click to A/B Testing from top of the list.
      //  driver.findElement(By.linkText("A/B Testing")).click();//yukarıdaki adrese gittik A/B sağ tuş incele higligth olan yere
        //(<a> olan yere linkin olduğu yere) double clik and copy/here "past" !!!elle kesinlikle yazma!!! said gurhan
        WebElement abTestLink=driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();//yukarıdaki tek satır kod yerine daha açıklayıcı ve okunabilir bu iki satırlık kodu tercih ettik!!

        //4- Verify title is:
        //  Expected: No A/B Test
        String expectedTitle="No A/B Test";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASS!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

        //5- Go back to home page by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //  Expected: Practice
         expectedTitle="Practice";//aynı vars lara tekrar atama (reassign) yaptık bir önceki sayfanın title nı kontrol ediyoruz burada da
         actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASS!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }



    }
}
/*
TC #2: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
  Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
  Expected: Practice
 */