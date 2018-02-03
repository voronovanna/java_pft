package ru.stqa.pft.addressbook;

public class GroupDataContacts {
  private final String name;
  private final String middle;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String phone;
  private final String phonemobile;
  private final String email;
  private final String testemail;
  private final String homepagetest;
  private final String address2;
  private final String testphone2;
  private final String notes;

  public GroupDataContacts(String name, String middle, String lastname, String nickname, String company, String address, String phone, String phonemobile, String email, String testemail, String homepagetest, String address2, String testphone2, String notes) {
    this.name = name;
    this.middle = middle;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.phonemobile = phonemobile;
    this.email = email;
    this.testemail = testemail;
    this.homepagetest = homepagetest;
    this.address2 = address2;
    this.testphone2 = testphone2;
    this.notes = notes;
  }

  public String getName() {
    return name;
  }

  public String getMiddle() {
    return middle;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getPhonemobile() {
    return phonemobile;
  }

  public String getEmail() {
    return email;
  }

  public String getTestemail() {
    return testemail;
  }

  public String getHomepagetest() {
    return homepagetest;
  }

  public String getAddress2() {
    return address2;
  }

  public String getTestphone2() {
    return testphone2;
  }

  public String getNotes() {
    return notes;
  }
}
