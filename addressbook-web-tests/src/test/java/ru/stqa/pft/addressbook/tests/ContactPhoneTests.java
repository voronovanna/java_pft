package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if (app.group().allCont().size()==0){
      app.group().createContacts(new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("1111").withPhonemobile("222").withWorkphone("333").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2(null).withTestphone2(null).withNotes(null), true);
      app.goTo().gotoHomePage();
    }
  }

  @Test
  public void testContactPhones(){
    app.goTo().gotoHomePage();
    GroupDataContacts contact = app.group().allContTests().iterator().next();
    GroupDataContacts contactInfoFromEditForm = app.group().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//  assertThat(contact.getPhone(), equalTo(cleaned(contactInfoFromEditForm.getPhone())));
//  assertThat(contact.getPhonemobile(), equalTo(cleaned(contactInfoFromEditForm.getPhonemobile())));
//  assertThat(contact.getWorkphone(), equalTo(cleaned(contactInfoFromEditForm.getWorkphone())));
  }

  private String mergePhones(GroupDataContacts contact) {
    return Arrays.asList(contact.getPhone(), contact.getPhonemobile(), contact.getWorkphone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
