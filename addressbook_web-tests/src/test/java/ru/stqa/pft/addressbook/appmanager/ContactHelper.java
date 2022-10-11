package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.List;

public class ContactHelper extends HelperBase{
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void initContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
      wd.findElement(By.xpath("//img[@alt='Edit']")).click();
  }
  public void returnToContactsList() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void submitContactModification() {

    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    selectInList(By.name("bday"),contactData.getBday());
    selectInList(By.name("bmonth"),contactData.getBmonth());
    type(By.name("byear"),contactData.getByear());
    type(By.name("address"),contactData.getAddress());
    attach(By.name("photo"), contactData.getPhoto());
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='"+id+"']")).click();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToContactsList();
  }
  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    returnToContactsList();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact);
    submitContactModification();
    returnToContactsList();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones)
              .withAddress(address).withAllEmails(allEmails));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withAddress(address)
            .withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }
}
