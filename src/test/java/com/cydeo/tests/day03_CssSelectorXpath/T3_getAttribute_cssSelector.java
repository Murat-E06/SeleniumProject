package com.cydeo.tests.day03_CssSelectorXpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {
    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        //WebElement signInButton= driver.findElement(By.className("login-btn")); önceden bu şekilde yapıyorduk fakat şimdi
        //                   tagName[attribute='value']
        //                    input[class='login-btn']
         //1.  LOCATED USING CLASS ATTRIBUTE
        // WebElement signInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));//cssSelector ile yaptık çok kullanılıyormuş

       //2.  LOCATED USING TYPE ATTRIBUTE
        // WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit']"));

        //3.  LOCATED USING VALUE ATTRIBUTE
        WebElement signInButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        String expectedButtonText="Log In";

        //getting the value of the attribute "value"
        String actualButtonText=signInButton.getAttribute("value");//getAttribute returns String

        System.out.println("actualButtonText = " + actualButtonText);

        if(actualButtonText.equals(expectedButtonText)){
            System.out.println("Log In Button Text Verification PASSED!");
        }else{
            System.out.println("Log In Button Text Verification FAILED!!!");
        }


        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from


    }
}
