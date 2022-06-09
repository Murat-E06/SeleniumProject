package com.cydeo.tests.day08_propoties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTablesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #1: Web table practice
        // 1. Go to: https://practice.cydeo.com/web-tables
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test(){

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        //firs we locate it cell and return it web element
        ////td[.='Bob Martin'](2.path)
        WebElement bobMartinCell=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        System.out.println("(bobMartinCell.getText()) = " + (bobMartinCell.getText()));

        String expectedBobName="Bob Martin";
        String actualBobName=bobMartinCell.getText();

        Assert.assertEquals(actualBobName,expectedBobName);
        //Assert.assertTrue(actualBobName.contains(expectedBobName));

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        //"//td[.='Bob Martin']/../td[5]" (2.path "/.." means that from child to parent)
        WebElement bobMartinDataCell=driver.
                findElement(By.xpath("table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedBobDate="12/31/2021";
        String actualBobDate=bobMartinCell.getText();

        Assert.assertEquals(actualBobDate,expectedBobDate);

    }

    //We use the utility method which we created next class
    @Test
    public void test2(){
        //utilities den çağıdı->WebTablesUtils.returnOrderDate
       String customerOrderDate1= WebTablesUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);//04/15/2021

        String customerOrderDate2= WebTablesUtils.returnOrderDate(driver,"Ned Stark");
        System.out.println("customerOrderDate2 = " + customerOrderDate2);

    }
    //Using WebtableUtils.orderVerify(); method
    @Test
    public void test3(){
        WebTablesUtils.orderVerify(driver, "Bart Fisher","01/16/2021");


    }



}
