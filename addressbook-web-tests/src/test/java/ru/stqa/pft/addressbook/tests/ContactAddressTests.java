package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactAddressTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if (app.group().allCont().size()==0){
      app.group().createContacts(new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("1111").withPhonemobile("222").withWorkphone("333").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2(null).withTestphone2(null).withGroup("test1").withNotes(null), true);
      app.goTo().gotoHomePage();
    }
  }

  @Test
  public void testContactAddress(){
    app.goTo().gotoHomePage();
    GroupDataContacts contact = app.group().allContTests().iterator().next();
    GroupDataContacts contactInfoFromEditForm = app.group().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
//  assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  public static String cleaned(String address){
    return address.replaceAll("\\s","").replaceAll("[-()]","");
  }

//    private String mergeAddress(GroupDataContacts contact) {
//    return Arrays.asList(contact.getAddress())
//            .stream().filter((s) -> ! s.equals(""))
//            .map(ContactPhoneTests::cleaned)
//            .collect(Collectors.joining("\n"));}

}