package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices_T5_StateDropdown {

    public WebDriver driver;

    @BeforeMethod//2. task T6 yı da bu clas da cozdu. oncesinde before method olusturdu, ilk 2 maddeyi T5 den cut yaptı
    //ve asagıdaki yeni olusturduğu setup metoda copy ledi. sonra driver fail verdi onun icinde yukarıdaki
    //public WebDriver driver; satırını ilave etti WebDriver ı burada tanımladı asağıdaki yerlerinde gerek kalmadı!!
    public void setupMethod(){
        //1. Open Chrome browser
         driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown_task5() {
        //TC #5: Selecting state from State dropdown and verifying result

        //we located dropdown and its ready to use
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //Use all Select options. (visible text, value, index)
        //3. Select Illinois
        stateDropdown.selectByVisibleText("Illinois");
        //4. Select Virginia
        stateDropdown.selectByValue("VA");
        //5. Select California
        stateDropdown.selectByIndex(5);//6. sırada teker teker saydık en üstte bir option daha var indexi 5 yapıyor!!

        //6. Verify final selected option is California.
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();//burada getText WEBELEMENT OLAN RETURN
        //type ı string return type a cevirdi!!!
        //hernekadar getFirstSelectedOption() method kullanıp 3.sırada sectigimiz californiayı çağırsak da
        //bu metod calls that currently selected option!!!
        String expectedOptionText="California";

        Assert.assertEquals(actualOptionText,expectedOptionText);


    }
    @Test
    public void dropdown_task6(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //ilk 2 madde yukarıda yapıldı !!
        //----------------------------------------

        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using  : visible text
        yearDropdown.selectByVisibleText("1923");
        //Select month using   : value attribute
        monthDropdown.selectByValue("11");
        //Select day using : index number
        dayDropdown.selectByIndex(0);//index starts from 0 (1 ama indexi 0)

        //creating expected values
        String expectedYear="1923";
        String expectedMonth="December";
        String expectedDay="1";

        //getting actual values from browser
        //dropdownlarda gettext() den önce bu getFirstSelectedOption() komutu kullanılıyor currently selected button ı veriyor
        String actualYear=yearDropdown.getFirstSelectedOption().getText();
        String actualMonth=monthDropdown.getFirstSelectedOption().getText();
        String  actualDay=dayDropdown.getFirstSelectedOption().getText();

        //create assertions
        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertTrue(actualMonth.equals(expectedMonth));
        Assert.assertTrue(actualDay.equals(expectedDay));

    }
    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }
}
