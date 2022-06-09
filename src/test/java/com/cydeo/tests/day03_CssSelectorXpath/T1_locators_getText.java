package com.cydeo.tests.day03_CssSelectorXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utulities.WebDriverFactory;

public class T1_locators_getText {
    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
       // WebDriverManager.chromedriver().setup();
       // WebDriver driver=new ChromeDriver();
        WebDriver driver= WebDriverFactory.getDriver("chrome");//yukarıdaki 2 satır yerine utilities den bu metodu cağırdık!!
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
       // driver.findElement(By.className("login-inp")).sendKeys("incorrect");//siteye gidip ilgili alanın classname ini copyaladık
        //illa  classname olmak zorunda değil 8 attr. var hepsi de çalışmak zorunda değil uygun olanını seçebiliyoruz!!
        //bu formu da kullanabiliriz WebElement olarak atayıp kullanmadık. zararı tek kullanımlık olması!!
       WebElement inputUserName= driver.findElement(By.className("login-inp"));
       inputUserName.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");

        //5- Click to login button.
        WebElement loginButton= driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage= driver.findElement(By.className("errortext"));

        String expectedErrorMessage="Incorrect login or password";
        String actualErrorMessage=errorMessage.getText();//getText converts webElement to String!!!

        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message verification PASSED!");
        }else{
            System.out.println("Error message verification FAILED!!!");
        }

        //PS: Inspect and decide which locator you should be using to locate web elements.
    }
}
