package PlaywrightBasic;

import java.util.List;

import com.microsoft.playwright.*;

public class LocatorCreation_5 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		//SINGLE ELEMENT
		
//		page.navigate("https://www.academy.naveenautomationlabs.com");
//		Locator webinarsButton = page.locator("text = Webinars");
//		webinarsButton.hover();
//		webinarsButton.click();
		
		//SINGLE ELEMENT
		
//		page.navigate("https://www.google.com/");
//		Locator gambarGoogle = page.locator("text = Gambar");
//		gambarGoogle.hover();
//		gambarGoogle.click();
		
		//MULTIPLE ELEMENTS
		//the locator is the same text, we can see how much that locator with same text in the traveloka
//		page.navigate("https://www.traveloka.com");
		//for example code below will be have an error
		//because car rental text have 3 elements in that page.
//		Locator carRentalButton = page.locator("text = Car Rental");
		
		//we can add .first() to point the first element
//		Locator carRentalButton = page.locator("text = Car Rental");
//		int totalCarRentalButton = carRentalButton.count();//3 elements
//		System.out.println(totalCarRentalButton);
		
		//we can print the count of the element
//		carRentalButton.first().hover();
//		carRentalButton.first().click();
		
		//MULTIPLE ELEMENT
		page.navigate("https://www.orangehrm.com/en/contact-sales/");
		//in locator using option, we can check the total of the options available
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());
		
		//here we want to get all of the text in country dropdown
//		for(int i=0; i < countryOptions.count(); i++) {
//			String countryName = countryOptions.nth(i).textContent();
//			System.out.println(countryName);
//		}
		
		//another simpler way
		List<String> optionsTextList = countryOptions.allTextContents();
		//we can do a for each to print the list
//		for(String e: optionsTextList) {
//			System.out.println(e);
//		}
		//or another way is using Lambda
		// ele is represent the string of optionsTextList
		optionsTextList.forEach(ele -> System.out.println(ele));
	}
	
}
