package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ChangePasswordHelper extends HelperBase{

  public ChangePasswordHelper (ApplicationManager app) {
    super(app);
  }

  public void chooseUser (String username, String email) {
    click(By.linkText("Manage"));
    click(By.linkText("Manage Users"));

    click(By.linkText("user3"));
    type(By.name("password"), "root");
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl")+"/signup_page.php");
    type(By.name("username"),username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value='Signup']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }

}
