package ru.stqa.selenium.pages;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeHelper extends Page
{

    @FindBy(xpath = "//mat-toolbar-row[@class='mat-toolbar-row']//a[1]")//поменяла чтобы охватить большую площадь нажатия кнопки
            WebElement loginButton;//"//span[contains(text(),'Login')]""//mat-toolbar-row[@class='mat-toolbar-row']//a[1]"

    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement createAccountButton;

    @FindBy(xpath = "//span[contains(text(),'Go to Event list')]")
    WebElement goToEventButton;
    @FindBy(xpath = "//h1[@class='mat-display-3']")//заголовок Sabbath in the  family
            WebElement header;


    public HomeHelper(WebDriver driver) {
        super ( driver );
    }

    public HomeHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded ( driver,
                        loginButton,
                55 );
        waitUntilElementIsLoaded ( driver,
                createAccountButton, 55 );
        waitUntilElementIsLoaded ( driver,
                header,
                55 );
        return this;
    }

    public String getGoToEventButtonName() {
        /*WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));*/
        return goToEventButton.getText ();
    }

    public HomeHelper pressGoToEventButton() {
        /*WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));*/
        goToEventButton.click ();
        return this;
    }

    public HomeHelper pressLoginButton() {
        /*WebElement login = driver.findElement(By
                .xpath("//span[contains(text(),'Login')]"));*/
        loginButton.click ();
        return this;
    }

    public HomeHelper pressCreateAccountButton() {

        createAccountButton.click ();
        return this;
    }


    public String getHeader() {


        return header.getText ();
    }
}
