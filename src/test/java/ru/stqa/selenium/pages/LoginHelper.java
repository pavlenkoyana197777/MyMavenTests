package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginHelper extends Page {
    @FindBy(xpath ="//span[contains(text(),'Cancel')]" )
    WebElement cancelButton;
    @FindBy(xpath ="//input[@formcontrolname='email']" )
    WebElement emailField;
            @FindBy(xpath ="//input[@formcontrolname='password']" )
            WebElement passwordField;

    @FindBy(xpath ="//span[contains(text(),'Log in')]" )
    WebElement loginButton;
    @FindBy(xpath ="//div[@class='alert alert-danger ng-star-inserted']")
    WebElement alertText;
    @FindBy(xpath = "//mat-icon[contains(text(),'email')]")
    WebElement labelEmail;


    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public LoginHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver, cancelButton,
                20);
        return this;
    }

    public LoginHelper enterValueToFieldEmail(String value) {
      setValueToField ( emailField,value );
      //emailField.click();
      //emailField.clear ();//очистка поляemailField.sendKeys(value);
        return this;
    }

    public LoginHelper enterValueToFieldPassword(String value) {
       setValueToField  (passwordField,value );
        return this;
    }
    public LoginHelper enterValueToFieldPasswordAcc() {//pllass
        setValueToFieldAfterAccountLogin(emailField);
        return this;

    }


    public LoginHelper pressLogInButton() {
        waitUntilElementIsLoaded(driver, loginButton,
                40);

        loginButton.click();
        return this;
    }

    public String getAlertText() {
        waitUntilElementIsLoaded(driver, alertText,
                40);

        return alertText.getText();

    }
    public LoginHelper pressCancelButton(){
        cancelButton.click();
        return this;
    }

    public LoginHelper waitUntilWindowIsClosed(){//метод исчезания окна в базовом абсент элемент
        waitUntilElementIsAbsent(driver, labelEmail,30);
        return this;
    }

}
