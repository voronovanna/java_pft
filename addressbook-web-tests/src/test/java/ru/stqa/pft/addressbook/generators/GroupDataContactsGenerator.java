package ru.stqa.pft.addressbook.generators;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataContactsGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    GroupDataContactsGenerator generator = new GroupDataContactsGenerator();
//  new JCommander(generator, args);
    JCommander JCommander = new JCommander (generator);
    try {
      JCommander.parse(args);
    } catch (ParameterException ex) {
      JCommander.usage();
      return;
    }
    generator.run();
//  int count = Integer.parseInt(args [0]);
//  File file = new File(args[1]);
  }

  private void run() throws IOException {
    List<GroupDataContacts> contacts = generateContacts(count);
    save (contacts, new File(file));
  }

  private void save(List<GroupDataContacts> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupDataContacts contact : contacts){
      writer.write(String.format("%s;%s;%s\n", contact.getName(), contact.getLastname(), contact.getAddress()));
    }
    writer.close();
  }

  private List<GroupDataContacts> generateContacts(int count) {
    List<GroupDataContacts> contacts = new ArrayList<GroupDataContacts>();
    for (int i = 0; i < count; i++){
      contacts.add(new GroupDataContacts().withName(String.format("testName %s", i))
              .withLastname(String.format("testLastname %s", i)).withAddress(String.format("testAddress %s", i)));
    }
    return contacts;
  }
}
