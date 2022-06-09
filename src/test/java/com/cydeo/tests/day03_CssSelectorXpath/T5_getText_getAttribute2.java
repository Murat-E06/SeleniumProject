package com.cydeo.tests.day03_CssSelectorXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utulities.WebDriverFactory;

public class T5_getText_getAttribute2 {
    public static void main(String[] args) {
        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Enter incorrect username into login box:
        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        loginBox.sendKeys("incorrect username" + Keys.ENTER);
        //4- Click to `Reset password` button
        WebElement resetPasswordButton = driver.findElement(By.tagName("button"));
        resetPasswordButton.click();

        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        String expectedErrorLabel="Login or E-mail not found";
        WebElement errorLabel=driver.findElement(By.className("errortext"));
        String actualErrorLabel=errorLabel.getText();
         if(actualErrorLabel.equals(expectedErrorLabel)){
             System.out.println("Error label verification PASSED!");
         }else{
             System.out.println("Error label verification FAILED!!!");
         }

        //PS: Inspect and decide which locator you should be using to locate web elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
