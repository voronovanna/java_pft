package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts2 extends ForwardingSet<ContactData> {

  private Set<ContactData> delegate;

  public Contacts2(Contacts2 contacts2) {
    this.delegate = new HashSet<ContactData>(contacts2.delegate);
  }

  public Contacts2() {
    this.delegate = new HashSet<ContactData>();
  }

  public Contacts2(Collection<ContactData> contacts2) {
    this.delegate = new HashSet<ContactData>(contacts2);
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts2 withAdded(ContactData contact2){
    Contacts2 contacts2 = new Contacts2(this);
    contacts2.add(contact2);
    return contacts2;
  }

  public Contacts2 without(ContactData contact2){
    Contacts2 contacts2 = new Contacts2(this);
    contacts2.remove(contact2);
    return contacts2;
  }

}
