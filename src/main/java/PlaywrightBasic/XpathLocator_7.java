package PlaywrightBasic;

import java.util.List;

import com.microsoft.playwright.*;

public class XpathLocator_7 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		//BASIC XPATH
//		page.navigate("https://www.amazon.com");
//		page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("Macbook Pro");
		//this is the same, without xpath=
//		page.locator("//input[@id='twotabsearchtextbox']").fill("Macbook Pro");
		
//		page.navigate("https://www.traveloka.com");
//		Locator totalAmazon = page.locator("//div[contains(text(),'Hotels')]");
//		System.out.println(totalAmazon.count());
//		
//		List<String> textList = totalAmazon.allInnerTexts();
//		for(String e : textList) {
//			System.out.println(e);
//		}
		
		//SIBLING CONCEPT, maybe it is the same to parent child concept
		page.navigate("https://selectorshub.com/xpath-practice-page");
//		page.locator("//a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();
		
		//indexing concept to check all the checkbox
		Locator checkboxTable = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
		for(int i=0;i<checkboxTable.count();i++) {
			//nth is method for locators index
			checkboxTable.nth(i).click();
		}
		
		//we also can do this with indexing xpath    
		//(//table[@id='resultTable']//input[@type='checkbox'])[4]
		//(//table[@id='resultTable']//input[@type='checkbox'])[position()]
		//(//table[@id='resultTable']//input[@type='checkbox'])[last()]
		
		//let say we want to click the 4th index and last index
		
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[4]").click();
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
		
	// TEST Re push git	tes 
	}

}
