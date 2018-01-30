package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

//  @BeforeMethod
//  public void setUp() throws Exception {
//    app.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
//    app.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    app.login("admin", "secret");
//  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

//  @AfterMethod
//  public void tearDown() {
//    app.wd.quit();
//  }

//  public ApplicationManager getApp() {
//    return app;
//  }
}
