package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupContactsCreation extends TestBase{

  @Test
  public void testGroupContactsCreation () {
    app.goTo().gotoHomePage();
    Contacts before = app.group().allCont();
    File photo = new File("src/test/resources/stru.jpg");
    GroupDataContacts contact = new GroupDataContacts().withName("TName3").withMiddle("Middle").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("444").withPhonemobile("555").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withPhoto(photo).withGroup("test1").withNotes("testNotes");
    app.gotoContactsCreationPage();
    app.group().createContacts(contact, true);
    Contacts after = app.group().allCont();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

/**  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }**/
}
