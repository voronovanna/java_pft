package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

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

  public void selectGroup() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));}
    }

    public void submitContactsCreation () {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactsForm (GroupDataContacts groupDataContacts){
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
      field(By.name("notes"), groupDataContacts.getNotes());
    }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void selectContact() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));}
  }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void initContactsModification() {
    click(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a"));
  }

  public void submitContactsModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }
}
