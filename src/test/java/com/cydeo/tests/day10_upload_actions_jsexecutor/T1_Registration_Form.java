package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationsReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_Registration_Form {
    @Test
    public void registration_form_test() {

        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        //Driver.getDriver()-->driver
        Driver.getDriver().get(ConfigurationsReader.getProperty("registration.form.url"));
        //confg.properties de burayı tanımladık ve oradan key i copy paste yaptık ama nereye ConfigurationsReader.getProperty
        //nin içine direk ilk get()in içine yazamıyoruz o da key in value si olan adrese götürüyor bizi

        //Create Java Faker
        Faker faker = new Faker();//isimleri faker dan almak için
        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        //Driver.getDriver()-->driver anlamına geliyor eskiden driver.findElement yazıyorduk şimdi Confg.Reader dan
        //çağırdığımız için böyle yapacak birşey yok!!
        inputFirstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        //  inputUserName.sendKeys(faker.name().username().replaceAll(".",""));//burada faker araya . koyan bir isim üretti
        //onu bu şekilde ayıkladık ya da 2. yol
        String user = faker.bothify("helpdesk###");
        inputUserName.sendKeys(user);//bu şekilde daha şık oluyormuş said Gurhan

        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@email.com");//sablon yaptık

        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.numerify("########"));//8 haneli olması isteniyor
        //faker.internet().password(); böyle de oluyormuş

        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
       inputGender.click();

        //10. Enter date of birth
        WebElement inputDateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
      // faker.number().numberBetween(1,12); bu şekilde daha specific yapılabilir
        inputDateOfBirth.sendKeys(faker.numerify("03/08/2000"));

        //11. Select Department/Office
        Select departmentDropdown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));//her seferinde 1-9 (0 dan başlıyor lakin 0. select başlık kısmına denk geliyor
        //arasında random seçim yapılsın diye

        //12. Select Job Title
        Select jobTitleDropdown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

        //13. Select programming language from checkboxes
        //14. Click to sign up button
        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.
    }
}
