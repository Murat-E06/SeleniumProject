package com.cydeo.tests.day11_driver_close_actions_jsexecuter_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.Driver;

public class T1_Circle_Drag_N_Drop {
    @Test
    public void drag_and_drop_test(){
        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index ");

        //Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton=Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //Locate the circles
        WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle=Driver.getDriver().findElement(By.id("droptarget"));

        //2. Drag and drop the small circle to bigger circle.
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle,bigCircle).perform();//dragAndDrop hazır komutunu kullandık küçüğü al büyüğe at!
       // actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();//aynı işi yapan farklı komut!!

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualBigCircleText=bigCircle.getText();
        String expectedBigCircleText="You did great!";

        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);




    }
}
