package com.cydeo.tests.day10_upload_actions_jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.BrowserUtils;
import utulities.ConfigurationsReader;
import utulities.Driver;

public class T2_UploadPractice {
    @Test
    public void upload_Test(){
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path="C:\\Users\\Murat\\Documents\\CYDEO\\11_Interview&Flipgrids\\06_VendingMachine.txt";//html dosyasından olafın adresini kopyaladık

        //3. Upload the file.
        WebElement fileUpload=Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);
        fileUpload.sendKeys(path);//burası çalışmıyor??? hata veriyor..

        WebElement uploadButton=Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //4. Assert:
        WebElement fileUploadedHeader=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed());

        //-File uploaded text is displayed on the page

    }
}