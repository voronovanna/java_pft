package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locatop) {
    wd.findElement(locatop).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text!=null){
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void field(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

//  public boolean isAlertPresent() {
//    try {
//      wd.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }

}
