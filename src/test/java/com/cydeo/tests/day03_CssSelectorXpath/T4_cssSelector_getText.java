package com.cydeo.tests.day03_CssSelectorXpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {
        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");

        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password

        //cssSelector with class attribute and its value
        // WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));

        //cssSelector with value attribute and its value
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        //ÖNEMLİ NOT: btn bunları yaptıktan sonra webpage in code bölümüne ctr+F ile açılan pencereye button[value='Reset password']
        //kısmını yapıştırıyoruz ve yukarıdaki kod bölmünün sarı highlight olduğunu yani doğru yerde çalıştığımızı double check yapıyoruz.

        String expectedResetPasswordButtonText = "Reset password";
        String actualResetPasswordButtonText = resetPasswordButton.getText();

        if(actualResetPasswordButtonText.equals(expectedResetPasswordButtonText)){
            System.out.println("Button test verification PASSED!");
        }else{
            System.out.println("Button test verification FAILED!!!");
        }

    }
}
