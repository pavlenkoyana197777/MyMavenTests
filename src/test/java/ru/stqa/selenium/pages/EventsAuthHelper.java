package ru.stqa.selenium.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EventsAuthHelper extends Page {//страница событий переход после лог ин возможен
    // только при заполненном профиле после создания аккаунтаю
    @FindBy(xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement menuButton;

    @FindBy(xpath = "//button[@class='mat-raised-button']")////span[contains(text(),'Filters')]//span[contains(text(),'Filters')]
            WebElement filterButton;


    public EventsAuthHelper(WebDriver driver) {
        super(driver);
    }

    public EventsAuthHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,menuButton ,30);//mat-icon[@class='but mat-icon material-icons']
       waitUntilElementIsLoaded(driver, filterButton,30);
        return this;
    }

    public String getTooltipIconMenu() {
        WebElement iconMenu = menuButton;

        return iconMenu.getAttribute("mattooltip");

    }
    public String getHeader() {//заголовок find element
        WebElement titlePage = driver.findElement( By
                .xpath("//h1[@class='gorisontal-center']"));
        return titlePage.getText();
    }

    public EventsAuthHelper menuButtonClick() {
        menuButton.click();
        return this;
    }
}