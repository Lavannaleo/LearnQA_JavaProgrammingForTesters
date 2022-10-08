package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensureContact(){
    app.contact().returnToContactsList();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Anna").withMiddlename("Maria").withLastname("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1990").withAddress("Moscow, Red Square, 3"));
    }
    app.contact().returnToContactsList();
  }

  @Test (enabled = true)
  public void testContactDeletion(){
    app.contact().returnToContactsList();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }
}
