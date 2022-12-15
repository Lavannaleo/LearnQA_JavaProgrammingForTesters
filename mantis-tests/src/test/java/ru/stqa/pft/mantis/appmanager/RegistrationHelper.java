package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper (ApplicationManager app) {
    super(app);
  }

  public void start(String username, String password) {

    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[value='Вход'"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Вход'"));
  }
}
