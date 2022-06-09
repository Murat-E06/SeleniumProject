package com.cydeo.tests.day11_driver_close_actions_jsexecuter_practices;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_5_Actions_Scroll {
    @Test
    public void scrollTest(){
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        WebElement poweredByCydeo=Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));
        //2nd locate: By.linkText("CYDEO")
        //3rd: a[@href='https://cydeo.com/']
        Actions actions=new Actions(Driver.getDriver());

        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(poweredByCydeo).pause(4000).perform();//pause 4000 msec.

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.

        //2- Scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();//klavyedeki page up butonunu
        // locate ettik (4 kere bastırdık tahmini) hazır komutlardan

    //Driver.getDriver().quit();//2. test başlayamaz /terminate unplug selenium)
        Driver.closeDriver();//Driver utulitydeki metodu çağırdık

    }
    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }



}
