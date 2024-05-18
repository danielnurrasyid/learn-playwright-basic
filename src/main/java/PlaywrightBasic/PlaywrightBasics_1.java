package PlaywrightBasic;
import com.microsoft.playwright.*;

public class PlaywrightBasics_1 {

	public static void main(String[] args) {
		//start playwright server
		Playwright playwright = Playwright.create();
		
		//which browser we want to use, and if don't use BrowserType, the chromium will be headless.
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.google.com");
		
		String title = page.title();
		System.out.println("page title is : " + title);
		
		String url = page.url();
		System.out.println("url is : " + url);
		
		browser.close();
		playwright.close();
	}
}
