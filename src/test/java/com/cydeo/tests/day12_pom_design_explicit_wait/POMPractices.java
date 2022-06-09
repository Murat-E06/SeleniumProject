package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LibraryLoginPage;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setupMethod(){

        //aşağıdaki iki satırı testlerden copy paste yaptık ve claslardan sildik gerek kalmadı!!

        Driver.getDriver().get("https://library2.cydeo.com");
        libraryLoginPage=new LibraryLoginPage();
    }

    @Test
    public void required_field_error_message_test(){
        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com

        //3- Do not enter any information
        //4- Click to “Sign in” button

        libraryLoginPage.signInButton.click();//calling const. in there and create an object

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
        //yukarıda library deki fieldRequiredErrorMessage a gidiyor oradaki mesajın yazıp yazmadığını
        // kontrol ediyor return type boolean

        Driver.closeDriver();

        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void invalid_email_format_error_messagetest(){
        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library2.cydeo.com


        //3- Enter invalid email format

        libraryLoginPage.inputUsername.sendKeys("somethingWrong");
        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        //Expected: Please enter a valid email address.

        Driver.closeDriver();

    }

    @Test
    public void library_negative_login(){
        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com


        //3- Enter incorrect username or incorrect password
        libraryLoginPage.inputUsername.sendKeys("wrong@username.come");
        libraryLoginPage.inputUsername.sendKeys("wronngpassword");

        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMassage.isDisplayed());


    }


}
