package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreationTests extends TestBase{

  @Test (enabled = true)
  public void testContactCreation() {
    app.contact().returnToContactsList();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/я.png");
    ContactData contact = new ContactData().withFirstname("Anna").withLastname("Larinco").withMiddlename("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1989").withAddress("Moscow, Red Square, 3").withPhoto(photo);
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
  }
}
