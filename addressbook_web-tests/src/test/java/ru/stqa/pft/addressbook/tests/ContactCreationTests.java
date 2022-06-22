package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Anna", "Maria", "Leonidova", "Leo", "lll@mail.ru", "1", "January", "1989", "Moscow, Red Square, 3", "+79998887766"));
    app.getContactHelper().returnToContactsList();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);
    app.logout();
  }

}
