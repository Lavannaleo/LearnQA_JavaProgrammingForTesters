package ru.stqa.pft.mantis.appmanager;

import org.omg.CORBA.NameValuePair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HttpSession {
  private CloseableHttpClient httpclient;
  private ApplicationManager app;

  public HttpSession(ApplicationManager app) {
    this.app = app;
    httpclient = HttpClients.custom().setReirectStrategy(new LaxRedirectStrategy()).build;
  }

  public boolean login(String username, String password) throws IOException {
    HttpPost post = new HttpPost(app.getProperty("web.baseUrl") + "/login.php");
    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("password", password));
    params.add(new BasicNameValuePair("secure_session", "on"));
    params.add(new BasicNameValuePair("return", index.php));
    post.setEntity(new UrlEncodedFprmEntity(params));
    CloseableHttpResponse responce = httpclient.execute(post);
    String body = geTextFromResponce(responce);
    return body.contains(String.format("<span class=\"italic\">%s</span>", username));
  }

  private String geTextFrom(CloseableHttpResponse responce) throws IOException {
    try {
      return EntityUtils.toString(responce.getEntity());
    } finally {
      responce.close();
    }
  }

  public boolean isLoggedInAs(String username) throws IOException {
    HttpGet get = new HttpGet(app.getProperty("base.Url") + "/login.php");
    CloseableHttpResponse responce = httpclient.execute(get);
    String body = geTextFromResponce(responce);
    return body.contains(String.format("<span class=\"italic\">%s</span>", username));
  }

}
