package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ChangePasswordHelper extends HelperBase {

  public ChangePasswordHelper(ApplicationManager app) {
    super(app);
  }

  public void chooseUser(String username) {
    click(By.linkText("Manage"));
    click(By.linkText("Manage Users"));
    click(By.linkText(username));
    click(By.cssSelector("input[value='Reset Password']"));
  }

  /**public void selectUserById(String userId) {
   wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", userId))).click();}
   **/

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }

  public void finish(String resetConfirmationLink, String user_password) {
    wd.get(resetConfirmationLink);
    type(By.name("password"), user_password);
    type(By.name("password_confirm"), user_password);
    click(By.cssSelector("input[value='Update User']"));
  }
}
