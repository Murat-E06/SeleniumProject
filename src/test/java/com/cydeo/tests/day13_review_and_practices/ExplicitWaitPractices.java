package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;
    @BeforeMethod
    public  void setupMethod(){
        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage=new DynamicControlsPage();
    }
    @Test
    public void remove_button_test(){

        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
       // Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//bu satırı
       // WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
      //  wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
       // Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//ve bu satırı sonradan ilave etti?
        //sonra sildi ve yaklasık yarım saat anlattı sonra da Browser utility ye burayı copy paste yaptı ama?
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);//ve en sonunda Browser utility de olusturduğu
        //bu metodu çağırdı buraya ama?

        //5- Verify:
        //a. Checkbox is not displayed

        try{
            //assertFalse method will pass if the boolean value is returned false
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());//bu iki satır da aynı işi yapıyormuş
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException noSuchElementException){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));

    }

    @Test
    public void enable_button_test(){
        //TC #3: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();
        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());//burada false aldık çünkü loading barın dolmasını beklemedik

        //4- Wait until “loading bar disappears”
        //calling our explicitWait method to wait loadingBar to disappear
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);//burada bekledik ve
        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());//true aldık..

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        //Check the String value is matching as expected
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));//burada kesme işaretinin farklı
        //olduğundan bahsetti



    }


}
