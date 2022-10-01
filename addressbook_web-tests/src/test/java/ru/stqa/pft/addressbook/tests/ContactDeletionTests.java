package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensureContact(){
    app.contact().returnToContactsList();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Anna").withMiddlename("Maria").withLastname("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1990").withAddress2("Moscow, Red Square, 3").withPhone2("+79998887766"));
    }
    app.contact().returnToContactsList();
  }

  @Test (enabled = true)
  public void testContactDeletion(){
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(deletedContact);
    Assert.assertEquals(after, before);
  }


}
