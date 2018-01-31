package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupContactsDeletion extends TestBase{
  @Test
  public void testContactsDeletion () {
    app.getNavigationHelper().gotoHomePage();
    app.getGroupHelper().selectContact();
    app.getGroupHelper().deleteSelectedContacts();
    app.getGroupHelper().acceptAlert();
  }

  }
