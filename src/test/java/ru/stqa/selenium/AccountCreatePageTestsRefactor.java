

package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;


public class AccountCreatePageTestsRefactor extends TestNgTestPage {
    HomeHelper homePage;
    AccountCreateHelper accountCreatePage;
    ProfileHelper profilePage;
    MenuHelper menuPage;
    LoginHelper loginPage;
    EventsAuthHelper eventsAuthPage;

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory.initElements ( driver, HomeHelper.class );
        accountCreatePage = PageFactory.initElements ( driver, AccountCreateHelper.class );
        profilePage = PageFactory.initElements(driver,
                ProfileHelper.class);
        menuPage = PageFactory
                .initElements(driver, MenuHelper.class);
        loginPage = PageFactory
                .initElements(driver, LoginHelper.class);
        eventsAuthPage = PageFactory
                .initElements(driver, EventsAuthHelper.class);
    }
    @Test
    public void createNewAccount() {
       // String email = latinDigitString ( 8 ) + "@gmail.com";
        homePage.waitUntilPageLoad ().
                 pressCreateAccountButton ();
        accountCreatePage.waitUntilPageLoad ().
                enterValueToFieldEmailRandom () ;
        accountCreatePage.enterValueToFieldPassword ( "123456" )
                .enterValueToFieldRepPassword ( "123456" )
                .pressRegistrationButton ();
        profilePage.waitUntilPageLoad ()
                .menuButtonClick ();
        menuPage.waitUntilPageLoad ()
                .pressLogOutButton ();
        homePage.waitUntilPageLoad ();
       // Assert.assertTrue(homePage.getHeader ()
               // .equals("Shabbat in the family circle"));//
         Assert.assertEquals ( homePage.getHeader (), "Shabbat in the family circle" );//сравниваем заголовки на страницах


    }




   @Test
    public void newAccountAndLogin(){

        homePage.waitUntilPageLoad ()
                .pressCreateAccountButton ();
        accountCreatePage.waitUntilPageLoad ()

                .enterValueToFieldEmailRandom ();
        String email = accountCreatePage.enterValueToFieldEmailRandom ();

       // надо поймать значение рондомное
        accountCreatePage.enterValueToFieldPassword ( "123456" )
              .enterValueToFieldRepPassword ( "123456" )
              .pressRegistrationButton ();
        profilePage.waitUntilPageLoad ()
                .menuButtonClick ();
        menuPage.waitUntilPageLoad ()
                .pressLogOutButton ();
        homePage.waitUntilPageLoad ();
        Assert.assertEquals ( homePage.getHeader (),"Shabbat in the family circle" );//сравниваем заголовки на страницах
        homePage.waitUntilPageLoad()
              .pressLoginButton();
        loginPage.waitUntilPageLoad()
              .enterValueToFieldEmail (email)//создан новый метод

               .enterValueToFieldPassword("123456")
               .pressLogInButton();
        eventsAuthPage.waitUntilPageLoad();

         Assert.assertEquals("Menu", eventsAuthPage.getTooltipIconMenu());
      // Assert.assertEquals("Find event",eventsAuthPage.getHeader());
   }
}
