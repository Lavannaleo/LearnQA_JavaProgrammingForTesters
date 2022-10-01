package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensureContact(){
    app.contact().returnToContactsList();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Anna").withMiddlename("Maria").withLastname("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1990").withAddress2("Moscow, Red Square, 3").withPhone2("+79998887766"));
    }
    app.contact().returnToContactsList();
  }

  @Test (enabled = true)
  public void testContactDeletion(){
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();

    before.remove(index);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
    //app.logout();
  }


}
