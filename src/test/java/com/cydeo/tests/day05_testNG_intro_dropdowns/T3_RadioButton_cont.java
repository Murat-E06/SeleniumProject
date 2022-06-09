package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_cont {
    public static void main(String[] args) {
        //TC #3: Utility method task for (continuation of Task2)
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Locate name='sports' radio buttons and store them in a List of Web Element

        //bu butonların ortak kapsayan elemanı sport
        //4. Verify “Hockey” radio button is selected after clicking.

        clickAndVerifyRadioButton(driver,"sport","hockey");
        clickAndVerifyRadioButton(driver,"sport","football");
        clickAndVerifyRadioButton(driver,"color","yellow");


    }
    //yukarıda soruyu çözmştk lakin aşağıdaki metoda aldık, kendimize metod yaptık!main metodun hemen dışına

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {
        List<WebElement> radioButton = driver.findElements(By.name("sport"));

        //Loop through the List of WebElement and select matching result "hockey"
        for (WebElement each : radioButton) {//sportRadioButton.iter yaptık sportRadioButton.for ile aynı
            String eachId = each.getAttribute("id");

            if (eachId.equals(idValue)) {
                each.click();

                System.out.println(eachId+" is selected: " + each.isSelected());
                break;
            }
        }
    }
}
