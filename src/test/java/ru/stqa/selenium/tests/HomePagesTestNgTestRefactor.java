package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.EventsAuthHelper;
import ru.stqa.selenium.pages.HomeHelper;
import ru.stqa.selenium.util.LogLog4j;

import java.util.logging.Logger;


public class HomePagesTestNgTestRefactor extends TestNgTestPage {
    HomeHelper homePage;
    EventsAuthHelper eventsUnAuthPage;
    private static Logger Log = Logger.getLogger( LogLog4j.class.getName());

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory
                .initElements(driver, HomeHelper.class);
        eventsUnAuthPage = PageFactory
                .initElements(driver, EventsAuthHelper.class);

    }
    @Test
    public void openHomePage()  {

        homePage.waitUntilPageLoad();
        String goToButtonName =
                homePage.getGoToEventButtonName();

        Assert.assertEquals("Go to Event list",goToButtonName);
    }

    @Test
    public void goToEventsTest()  {
        homePage.waitUntilPageLoad()
             .pressGoToEventButton();
        eventsUnAuthPage.waitUntilPageLoad();
        String header = eventsUnAuthPage.getHeader();
        Assert.assertEquals("Find event",header);
    }

}
