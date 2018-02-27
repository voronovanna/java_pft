package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<GroupDataContacts> {

  private Set<GroupDataContacts> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<GroupDataContacts>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<GroupDataContacts>();
  }

  public Contacts(Collection<GroupDataContacts> contacts) {
    this.delegate = new HashSet<GroupDataContacts>(contacts);
  }

  @Override
  protected Set<GroupDataContacts> delegate() {
    return delegate;
  }

  public Contacts withAdded(GroupDataContacts contact){
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(GroupDataContacts contact){
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }

}
