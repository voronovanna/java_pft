package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() { app.mail().start(); }

  @Test
  public void testChangePassword() throws IOException, InterruptedException {
    long now = System.currentTimeMillis();
    String user = String.format("user%s", now);
    String password = "password";
    String email = String.format("user%s@localhost", now);
    app.registration().start(user, email);

    List<MailMessage> mailMessages = app.mail().waitForMail(2, 5000);
    String registrationConfirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(registrationConfirmationLink, password);

    app.change().login(app.getProperty("web.adminLogin").toString(), app.getProperty("web.adminPassword").toString());
    app.change().chooseUser(user);

    List<MailMessage> newMailMessages = app.mail().waitForMail(2, 5000);
    String resetConfirmationLink = findChangePasswordLink(newMailMessages, email);
    String password_2 = "password_2";
    app.change().finish(resetConfirmationLink, password_2);

    assertTrue(app.newSession().login(user, password_2));
  }

  @AfterMethod
  public void stopMailServer() { app.mail().stop(); }

  private String findChangePasswordLink(List<MailMessage> mailMessages, String user_email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(user_email)).collect(Collectors.toList()).get(1);
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
