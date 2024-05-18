package PlaywrightBasic;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


/*
 * TODO the Code generator or Record
 * Just go to the directory of the project
 * Open the cmd in that directory
 * run mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen wikipedia.com"
 * */

/*
 * TODO DEBUGING Provided by Playwright
 * RIGHT CLICK
 * RUN As
 * CLICK Run Configuration
 * Click tab Environment
 * Add Variable PWDEBUG with value 1
 * Click Apply
 * Click Run
 * 
 * TODO DEBUGGING Provided by Tools (Eclips)
 * simply right click and Debug As Java App	
 * 
 * TODO DEBUGGING
 * page.pause()
 * 
 * */

public class CodeGeneratorAndDebugging_2 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://academy.naveenautomationlabs.com/");
      /*
       * This line you can Use to Debugging. 
       * Before that we need to remove the variable in environment
       * 
       * */
      page.pause();
      
//      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.getByText("Login").click();
      page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("daniel");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("daniel@gmail.com");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("1234567890");
      page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Indonesia: +")).click();
      page.frameLocator("#microfe-popup-login").getByRole(AriaRole.OPTION, new FrameLocator.GetByRoleOptions().setName("Jordan+")).click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+962 124 124 124 124");
      page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();
      assertThat(page.locator("[id=\"\\31 611313114774d\"]")).containsText("Naveen Automation Academy");
      
    }
  }
}