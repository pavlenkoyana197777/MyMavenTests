package ru.stqa.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.Random;


public class TestNgTestPage {

  protected static URL gridHubUrl = null;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  /*@BeforeSuite
  public void initTestSuite() throws IOException {
    SuiteConfiguration config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
  }

  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }*/
  @BeforeMethod//@BeforeSuite//only first
  //запускает этот метод перед каждым тестом в основном классе
  public void initWebDriver(){
    driver = new ChromeDriver ();
    driver.get("https://mish.sheygam.com/#/wellcome");
    driver.manage().window().maximize();
  }
  @AfterMethod//после всех тестов выполняется этот методб=указывает на место где запускать//
  public void  tearDown(){
    driver.quit ();
  }
  public void waitUntilElementIsLoaded(WebDriver driver, By Locator, int time) {
    try {
      //определяет прогрузился ли элемент нужного локатора, замена задержкию максимальное время параметр тайм
      //(можно завязаться по локатору в случае списка элементов в локатореюпросто по локаторую после кликаю когда исчезнет
      new WebDriverWait ( driver, time ).until ( ExpectedConditions.presenceOfElementLocated ( Locator ) );

    } catch (Exception e) {
      e.printStackTrace ();
    }
  }
  public static String latinDigitString(int length){
    String str = "";
    //char ch;
    int number;
    Random gen = new Random ();
    //int i = 0;
    do {
      number = '0' + gen.nextInt('z' - '0' +1);
      if ((number <= '9') || (number >= 'A' && number <= 'Z') || (number >= 'a'))
      {
        str = str + (char)number;
      }
    }while(str.length()<length);
    return str;
  }

}
