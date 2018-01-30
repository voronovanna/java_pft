package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  private NavigationHelper navigationHelper;
  public GroupHelper groupHelper;
  public SessionHelper sessionHelper;

  public void init() {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

//  public void login(String username, String password) {
//    wd.get("http://localhost/addressbook/edit.php");
//    wd.findElement(By.id("header")).click();
//    wd.findElement(By.name("user")).click();
//    wd.findElement(By.name("user")).clear();
//    wd.findElement(By.name("user")).sendKeys(username);
//    wd.findElement(By.id("LoginForm")).click();
//    wd.findElement(By.name("pass")).click();
//    wd.findElement(By.name("pass")).clear();
//    wd.findElement(By.name("pass")).sendKeys(password);
//    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
//  }

  public void stop() { wd.quit();
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public void gotoContactsCreationPage() {
    navigationHelper.gotoContactsCreationPage();
  }
}
