package com.cydeo.tests.day04_findElements_checkboxes_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utulities.WebDriverFactory;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {
        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password ");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //using by cssSelector
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //a[class='nav-link'] yi HTML kod bölmnde crl F penceresine yapıştırdık 1of1 olduğunu doğru yerde olduğumuzdan
        //emin olduk double check!!

        //using cssSelector syntax#2                         tagName.classValue
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        //using cssSelector, href value
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //b. “Forgot password” header
        //locate header using cssSelector: locate parent element and move down to h2
        WebElement header_ex1 = driver.findElement(By.cssSelector("div.example >h2"));

        //locate header using xpath
        // WebElement header_ex2=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement header_ex2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        //c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
       WebElement inputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));

       //using xpath contains method
        // tagName[contains(@attribute,'value']
      // WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z']"));

        //e. “Retrieve password” button
        //button[@type='submit']
        //button[@class='radius'] are the same area markers if you want you can use them also
        WebElement retrievePasswordButton=driver.findElement(By.xpath("//button[@id='form_submit']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText=driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());//homeLink_ex1.isDisplayed().soutv yaptık isdisplay wheather isdisplay or not
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());//true
        System.out.println("emailLabel.isDisplayed() = " + emailLabel.isDisplayed());//true
        System.out.println("inputBox_ex1.isDisplayed() = " + inputBox_ex1.isDisplayed());//true
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());//true
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());//true

        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible

        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible
    }
}
