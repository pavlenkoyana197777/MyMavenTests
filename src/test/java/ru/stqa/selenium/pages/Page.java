package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;



  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }
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
    //метод нажатия и заполнения и стирания
  }
  public void setValueToField (WebElement element, String value){
    element.click ();
    element.clear ();//очистка поля
    element.sendKeys ( value );


  }
  public void setValueToFieldAfterAccountLogin(WebElement element){
    element.click ();
    element.clear ();
  }
  public static String latinDigitString(int length){
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
}
