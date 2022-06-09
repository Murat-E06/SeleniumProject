package com.cydeo.tests.day10_upload_actions_jsexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utulities.BrowserUtils;
import utulities.Driver;

public class T6_JavascriptExecutor {
    @Test
    public void javascript_executor_test1(){
        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //3- Use below JavaScript method and scroll
        //driver bu javascript komutlarına aşina olabilmesi için downcasting yapıyoruz onu javascript ol. zannettiriyoruz ki
        //komutları anlayabşlsin direk driver getdriver.javascript yazınca error veriyor!!

        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();//downcasting

        //a.  750 pixels down 10 times.
        for (int i = 0; i <10 ; i++) {//10 kere yapsın diye aynı komutu 10 kez aşağı indirecek sayfayı 1 roll down=750 pixell
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");//aşağıdaki metodu copy paste yaptık
        }


        //b.  750 pixels up 10 times
        for (int i = 0; i <10 ; i++) {//10 kere yapsın diye aynı komutu 10 kez yukarı indirecek sayfayı bu sefer de -750 yaptık
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");//aşağıdaki metodu copy paste yaptık
        }
        //JavaScript method to use : window.scrollBy(0,0)



    }
}
