package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  @Test
  public void testLogin() {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
