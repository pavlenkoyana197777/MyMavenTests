package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;
import ru.stqa.selenium.util.DataProviders;

public class LoginPageTestsProvider extends TestNgTestPage{
    HomeHelper homePage;
    LoginHelper loginPage;
    EventsAuthHelper eventsAuthPage;
    MenuHelper menuPage;
    ProfileHelper profilePage;
    @BeforeMethod
    public void initPage(){
        homePage = PageFactory
                .initElements(driver, HomeHelper.class);
        loginPage = PageFactory
                .initElements(driver, LoginHelper.class);
        eventsAuthPage = PageFactory.initElements(driver,
                EventsAuthHelper.class);
        menuPage = PageFactory
                .initElements(driver, MenuHelper.class);
        profilePage = PageFactory.initElements(driver,
                ProfileHelper.class);

    }




    @Test(dataProviderClass = DataProviders.class,dataProvider = "LoginList")//גв скобках название метода из DataPositive
    public void loginPositive(String email,String password)  {
        homePage.waitUntilPageLoad()
                .pressLoginButton();
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton();
        eventsAuthPage.waitUntilPageLoad();
        Assert.assertEquals("Menu", eventsAuthPage.getTooltipIconMenu());
        Assert.assertEquals("Find event",eventsAuthPage.getHeader());
        profilePage.menuButtonClick ();
        menuPage.waitUntilPageLoad ()
                .pressLogOutButton ();
        homePage.waitUntilPageLoad ();
        Assert.assertEquals ( homePage.getHeader (),"Shabbat in the family circle" );
        driver.quit ();
    }

    @Test (dataProviderClass = DataProviders.class,dataProvider = "loginPositiveProvider")//**chooseDataFromFile
    public void loginPositiveMaven(String email,String password)  {
        homePage.waitUntilPageLoad()
                .pressLoginButton();
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton();
        eventsAuthPage.waitUntilPageLoad();
        Assert.assertEquals("Menu", eventsAuthPage.getTooltipIconMenu());
        Assert.assertEquals("Find event",eventsAuthPage.getHeader());
        profilePage.menuButtonClick ();
        menuPage.waitUntilPageLoad ()
                .pressLogOutButton ();
        homePage.waitUntilPageLoad ();
        Assert.assertEquals ( homePage.getHeader (),"Shabbat in the family circle" );
        driver.quit ();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "loginNegativeProvider")//**chooseDataFromFile Test false email and password
    public void loginNegativeProvider(String email,String password){
        homePage.waitUntilPageLoad()//задержка на кнопку фккаунт и логин
                .pressLoginButton();
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
        .pressLogInButton ();
        Assert.assertEquals("Wrong authorization, login or password",
             loginPage.getAlertText());
        loginPage.pressCancelButton ();
        driver.quit ();
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "loginNegativeProvider")//**11chooseDataFromFile Test false email and password
    public void loginNegativeProviderAbsent(String email,String password){
        homePage.waitUntilPageLoad()//задержка на кнопку фккаунт и логин
                .pressLoginButton();
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton ();
        Assert.assertEquals("Wrong authorization, login or password",
                loginPage.getAlertText());
        loginPage.pressCancelButton ()
                .waitUntilWindowIsClosed ();
        Assert.assertEquals ( homePage.getHeader (),"Shabbat in the family circle" );

    }

}
