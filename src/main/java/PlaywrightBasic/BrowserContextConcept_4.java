package PlaywrightBasic;

import com.microsoft.playwright.*;

/*
 * Browser can create BrowserContext
 * that each context can have different test case with different application running
 * each context is isolated so that they cannot collide each other
 * */
public class BrowserContextConcept_4 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bx2 = browser.newContext();
		Page p2 = bx2.newPage();
		p2.navigate("https://www.google.com");
		System.out.println(p2.title());
		
		BrowserContext bx1 = browser.newContext();
		Page p1 = bx1.newPage();
		p1.navigate("https://www.orangehrm.com/");
		p1.fill("#Form_submitForm_EmailHomePage", "daniel");
		System.out.println(p1.title());
		
		bx2.close();
		p2.close();
		
		bx1.close();
		p1.close();
		
		
		
	}
	
}
