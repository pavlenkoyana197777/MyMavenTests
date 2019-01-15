package ru.stqa.selenium.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountCreateHelper extends Page {
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@formcontrolname='passwordRep']")
    WebElement repPasswordField;
    @FindBy(xpath = "//span[contains(text(),'Registration')]")
    WebElement registrationButton;

    public AccountCreateHelper(WebDriver driver) {
        super(driver);
    }

    public AccountCreateHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,cancelButton, 40);
        return this;
    }

   public AccountCreateHelper enterValueToFieldEmail(String value) {
        setValueToField(emailField,value );
       return this;
    }


    public AccountCreateHelper enterValueToFieldPassword(String value) {
        setValueToField(passwordField,value);
        return this;
    }

    public AccountCreateHelper enterValueToFieldRepPassword(String value) {
        setValueToField(repPasswordField,value);
        return this;
    }
    public AccountCreateHelper pressRegistrationButton(){
        waitUntilElementIsLoaded(driver, registrationButton,20);
        registrationButton.click();
        return this;
    }

    public String enterValueToFieldEmailRandom() {
        String email = latinDigitString(10)+"@gmail.com";
        setValueToField(emailField,email);
        return email;
    }

}
