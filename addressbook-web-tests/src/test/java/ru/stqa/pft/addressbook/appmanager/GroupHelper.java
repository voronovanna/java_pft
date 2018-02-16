package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
//  if (!wd.findElement(By.name("selected[]")).isSelected()) {
//  click(By.name("selected[]")); }

  }

  public void submitContactsCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactsForm(GroupDataContacts groupDataContacts, boolean creation) {
    field(By.name("firstname"), groupDataContacts.getName());
    field(By.name("middlename"), groupDataContacts.getMiddle());
    field(By.name("lastname"), groupDataContacts.getLastname());
    field(By.name("nickname"), groupDataContacts.getNickname());
    field(By.name("company"), groupDataContacts.getCompany());
    field(By.name("address"), groupDataContacts.getAddress());
    field(By.name("home"), groupDataContacts.getPhone());
    field(By.name("mobile"), groupDataContacts.getPhonemobile());
    field(By.name("email"), groupDataContacts.getEmail());
    field(By.name("email"), groupDataContacts.getTestemail());
    field(By.name("homepage"), groupDataContacts.getHomepagetest());
    field(By.name("address2"), groupDataContacts.getAddress2());
    field(By.name("phone2"), groupDataContacts.getTestphone2());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupDataContacts.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    field(By.name("notes"), groupDataContacts.getNotes());
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void initGroupModification() { click(By.name("edit")); }

  public void getIndexContact(int index) {
    wd.findElements(By.name("selected[]")).get(index);
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
   }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void initContactsModification() {
   click(By.cssSelector("tr:last-child td:nth-child(8)"));
  }

  public void submitContactsModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(int index, GroupData group) {
    selectGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContacts(GroupDataContacts groupContacts, boolean b) {
    initContactCreation();
    fillContactsForm(groupContacts, true);
    submitContactsCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
     return groups;
  }

  public List<GroupDataContacts> getContactsList() {
    List<GroupDataContacts> contacts = new ArrayList<GroupDataContacts>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element:elements){
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      GroupDataContacts contact = new GroupDataContacts(id, name, null, lastname, null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

  public int getContactsCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }
}
