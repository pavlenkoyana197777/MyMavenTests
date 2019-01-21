package ru.stqa.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Random;


public abstract class Page {

  protected WebDriver driver;



  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }


  public void goBackBrowserButton() {
    driver.navigate().back();
  }

  public void goForwardBrowserButton() {
    driver.navigate().forward();
  }

  public void reloadPage() {
    driver.navigate().refresh();
  }
//*************************************************************************************************************//
 //метод задержки через локатор и элемент//
  public void waitUntilElementIsLoaded(WebDriver driver,
                                       By locator, int time)
  {
    try {
      new WebDriverWait (driver, time).until( ExpectedConditions
              .presenceOfElementLocated(locator));
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  public void waitUntilElementIsLoaded(WebDriver driver,
                                       WebElement element, int time) {
    try {
      new WebDriverWait ( driver, time ).until ( ExpectedConditions
              .visibilityOf ( element ) );
    } catch (Exception e) {
      e.printStackTrace ();
    }

  }
  //****************************//метод нажатия и заполнения и стирания*********************************//
  public void setValueToField (WebElement element, String value){
    element.click ();
    element.clear ();//очистка поля
    element.sendKeys ( value );


  }
  //****************нажатие и очистка****************//
  public void setValueToFieldAfterAccountLogin(WebElement element){
    element.click ();
    element.clear ();
  }
  //***********метод рандом майл***************************//

  public static String latinDigitString(int length){//рандом метод майл
    String str = "";
    // char ch;
    int number;
    Random gen = new Random();
    // int i = 0;
    do {
      number = '0' + gen.nextInt('z' - '0' +1);
      if ((number <= '9') || (number >= 'A' && number <= 'Z') || (number >= 'a'))
      {
        str = str + (char)number;
      }
    }while(str.length()<length);
    return str;
  }
  //**************************************************************//

  public void moveMouseOverElement(WebElement element) {
    String javaScript = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);";


    ((JavascriptExecutor) driver).executeScript(javaScript, element);
  }

  public boolean verifyElementIsPresent(WebElement element) {
    try {
      element.getTagName();
      return true;
    } catch (NoSuchElementException e) {
      //  Log.info("---------------------------------");
      //  Log.info("element " + element + " can not be found by  element.getTagName()");
      //   Log.info("---------------------------------");
      return false;
    }
  }

  public boolean verifyTextBoolean(WebElement element, String text) {
    //  Log.info("verifying that text from element " + element + " - ('" + element.getText() + "') - is equal to text '" + text + "'");
    return text.equals(element.getText());
  }
  public void waitUntilElementIsDisappeared(WebDriver driver,//тоже самое на исчезание элемента только через локатор
                                            By locator, int time)
  {
    try {
      new WebDriverWait(driver, time).until(absenceOfElementLocated(locator));
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  //**********************исчезновение элемента*********************//

  public static ExpectedCondition<Boolean> absenceOfElementLocated(
          final By locator) {
    return new ExpectedCondition<Boolean>() {

      @Override
      public Boolean apply(WebDriver driver) {
        try {
          driver.findElement(locator).isDisplayed();
          return false;
        } catch (NoSuchElementException e) {
          return true;
        } catch (StaleElementReferenceException e) {
          return true;
        }
      }
      @Override
      public String toString() {
        return "element to not being present: " + locator;
      }
    };
  }
  public static ExpectedCondition<Boolean> absenceOfElement(
          final WebElement element) {
    return new ExpectedCondition<Boolean>() {

      @Override
      public Boolean apply(WebDriver driver) {
        try {
          element.getTagName();
          return false;
        } catch (NoSuchElementException e) {
          return true;
        } catch (StaleElementReferenceException e) {
          return true;
        }
      }
    };
  }


  public void waitUntilElementIsAbsent(WebDriver driver,//ждет пока исчезнет элемент
                                       WebElement element, int time)
  {
    try {
      new WebDriverWait(driver, time).until(absenceOfElement(element));
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

}