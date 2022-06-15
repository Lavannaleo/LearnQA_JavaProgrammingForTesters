package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("New Test", "Header", "Footer"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().iniGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("TestGroup", "TestHeader", "TestFooter"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

}
