package com.cydeo.tests.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //1.Set up the "browser driver"
        WebDriverManager.chromedriver().setup();


        //2.Create instance of Selenium WebDriver
        //This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();
        //SeleniumID:58SJHKFDGHD58 for ex. to understood session

        //This line will maximize the browser size
        driver.manage().window().maximize();

        // driver.manage().window().fullscreen(); // mac icin bazen windows ta çalısmıyormus

        //3.Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);//currentTitle = Electric Cars, Solar & Clean Energy | Tesla

        //get the title of the page
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);//currentURL = https://www.tesla.com/

        //Stop code exection for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();
        Thread.sleep(3000);

        //use selenium to navigate forward
        driver.navigate().forward();
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();
        Thread.sleep(3000);

        //use navigate().to():
        driver.navigate().to("https://www.google.com");

        //get the title of the page// driver.getTitle().soutv yaptık!
        // System.out.println("driver.getTitle() = " + driver.getTitle());

        String currentTitle2 = driver.getTitle();//II. yol
        System.out.println("currentTitle2 = " + currentTitle2);//Google (en son google da kaldığımız için onu veriyor tesla nın ardından yazsaydık tesla yazacaktı

        //get the title of the page
        String currentURL2 = driver.getCurrentUrl();
        System.out.println("currentURL2 = " + currentURL2);//https://www.google.com/

        //this will close the currently opened only one of window
        driver.close();

        //close all of the opened windows. it kills the current session(oturum)
        driver.quit();

    }
}
