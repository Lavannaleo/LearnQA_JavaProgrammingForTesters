package ru.stqa.pft.addressbook;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("New Test", "Header", "Footer"));
    submitGroupCreation();
    returnToGroupPage();
    logout();
  }


}
