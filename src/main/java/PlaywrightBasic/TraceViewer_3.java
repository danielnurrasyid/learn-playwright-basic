package PlaywrightBasic;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class TraceViewer_3 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      //start Tracing before creating/navigating a page.
      context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
      
      Page page = context.newPage();
      page.navigate("https://academy.naveenautomationlabs.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses").setExact(true)).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("daniel");
      page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      
      //Stop Tracing and export it into a zip archive
      context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
      
      /*
       * after we run the test case
       * we can see trace.zip in our project
       * simply go to trace.playwright.dev
       * select the zip file.
       * and we can see the result of documentation
       * */
     
    
    }
  }
}