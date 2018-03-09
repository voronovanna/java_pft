package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
      if (app.db().contacts().size() == 0) {
        createContact();
      }
      if (app.db().groups().size() == 0) {
        createGroup();
      }
    }

    private void createContact() {
      app.goTo().gotoHomePage();
      app.contact().create2(
              new ContactData()
                      .withName("Name").withLastname("Lastname").withHomePhone("333")
                      .withEmail("test@test.com").withAddress("Hackerway 1"), true);
    }

    private void createGroup() {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("group1").withHeader("header1").withFooter("footer2"));
    }


  @Test
  public void testAddContactToGroup (){

      Groups groups = app.db().groups();
      Contacts2 before = app.db().contacts2();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact2 = new ContactData().withId(modifiedContact.getId()).inGroup(groups.iterator().next());
      app.goTo().gotoHomePage();
      app.contact().addGroup(contact2);
      assertThat(app.contact2().count(), equalTo(before.size()));
      Contacts2 after = app.db().contacts2();
      assertThat(after, equalTo(before.without(contact2)));
      verifyContactListInUI();
    }

}
