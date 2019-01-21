package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;
import ru.stqa.selenium.util.DataProviders;


public class LoginPageTestsRefactor extends TestNgTestPage {
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

    @Test
    public void loginPositive()  {
        homePage.waitUntilPageLoad()
             .pressLoginButton();
        loginPage.waitUntilPageLoad()
              .enterValueToFieldEmail("yanina56@gmail.com")
              .enterValueToFieldPassword("123456")
              .pressLogInButton();
        eventsAuthPage.waitUntilPageLoad();
        Assert.assertEquals("Menu", eventsAuthPage.getTooltipIconMenu());
        Assert.assertEquals("Find event",eventsAuthPage.getHeader());
        profilePage.menuButtonClick ();
        menuPage.waitUntilPageLoad ()
             .pressLogOutButton ();
        homePage.waitUntilPageLoad ();
        Assert.assertEquals ( homePage.getHeader (),"Shabbat in the family circle" );


    }

    @Test
    public void loginNegative(){
        homePage.waitUntilPageLoad()//задержка на кнопку фккаунт и логин
               .pressLoginButton();
        loginPage.waitUntilPageLoad()
               .enterValueToFieldEmail("yanina56@gmail.com")
               .enterValueToFieldPassword("marina")
               .pressLogInButton();


        Assert.assertEquals("Wrong authorization, login or password",
                loginPage.getAlertText());
    }

    }