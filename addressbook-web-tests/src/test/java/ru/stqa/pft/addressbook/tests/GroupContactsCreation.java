package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupContactsCreation extends TestBase{

  @Test
  public void testGroupContactsCreation () {
    app.goTo().gotoHomePage();
    Contacts before = app.group().allCont();
    GroupDataContacts contact = new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("testPhoneHome").withPhonemobile("testMobile").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withTestphone2("testHome2").withGroup("test1").withNotes("testNotes");
    app.gotoContactsCreationPage();
    app.group().createContacts(contact, true);
    Contacts after = app.group().allCont();
    assertThat(after.size(), equalTo(before.size() + 1));

//  contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
//  before.add(contact);
//  Comparator<? super GroupDataContacts> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
//  before.sort(byId);
//  after.sort(byId);
//  Assert.assertEquals(before, after);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

}
