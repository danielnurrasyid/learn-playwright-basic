package PlaywrightBasic;

import com.microsoft.playwright.*;

public class TextSelector_6 {

	public static void main(String[] args) {
		
		/*
		 * Playwright Selectors
		 * 
		 * Text Selector
		 * CSS Selector
		 * Selecting visible elements
		 * Selecting elements that contain other elements
		 * Selecting elements matching one of he conditions
		 * Selecting elements in Shadow DOM
		 * Selecting elements based on layout
		 * XPath Selector
		 * React Selectors
		 * Vue Selectors
		 * id, data-testid, data-test-id, data-test selectors
		 * Pick n-th match from the query result
		 * Chaining Selectors
		 * 
		 * 
		 * */
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
//		page.navigate("https://www.orangehrm.com/en/contact-sales/");
		//page.locator("text=Contact Sales").click();
//		Locator privacy = page.locator("text=Privacy Policy");
//		for(int i=0; i<privacy.count();i++) {
////			System.out.println(privacy.nth(i).textContent());
//			String text = privacy.nth(i).textContent();
//			// if we found text Service Privacy Policy, then click it
//			if(text.contains("Service Privacy Policy")) {
//				privacy.nth(i).click();
//				break;
//			}
//			
//		}
		
		//change to this url
		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		
		//has-text() is a method
		//in locator we can create parent child concept
		//"[parent] [child]"
		//"[div.card-body] [h2:has-text('New Customer')]"
		String header = page.locator("div.card-body h2:has-text('New Customer')").textContent();
		System.out.println(header);
		
		// we can use '' to represent text=Register Account
		String store = page.locator("'Register Account'").textContent();
		System.out.println(store);
		
		//if there is more than 1 elements with the same text
		//we have to use parent child locator concept
		
		
		//for example text login we want to get is button login
		//as we can see in the ui there is 3 elements using text login
		
		//button login
		page.locator("form a:has-text('Password')").hover();
		page.locator("form a:has-text('Password')").click();
		
		
		
	}
	
}
