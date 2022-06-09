package pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    //1.initialize the driver instance and object of class
    public LibraryLoginPage(){
        //initElement method will create connection in between the
        // current driver session (instance) and the object of current class.
        PageFactory.initElements(Driver.getDriver(),this);//this referring current class objects
    }
    //aşağıda web elementleri locate ediyoruz daha sonra defalrca kullanacağımız yerleri
    //baştan tespit ediyoruz->Library

    //2. use @FindBy annotation to locate web elements
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(id="inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']/div")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath ="//div[.='Sorry, Wrong Email or Password']" )
    public WebElement wrongEmailOrPasswordErrorMassage;






}
