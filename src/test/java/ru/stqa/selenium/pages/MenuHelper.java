package ru.stqa.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MenuHelper extends Page {
    @FindBy(xpath = "//span[@class='marginLeft']")
    WebElement logOutButton;

    public MenuHelper(WebDriver driver) {
        super(driver);
    }
    public MenuHelper waitUntilPageLoad(){
        waitUntilElementIsLoaded(driver, logOutButton, 40);
        return this;
    }

    public MenuHelper pressLogOutButton(){
        logOutButton.click();
        return this;
    }
}
