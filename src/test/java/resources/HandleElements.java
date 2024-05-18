package resources;
import com.microsoft.playwright.*;


public class HandleElements {
	private final Page pages;	
	private final Locator searchTermInput;
	private final Locator buttonSearch;
	
	public HandleElements(Page page) {
		this.pages = page;
		this.searchTermInput = page.locator("textarea[name='q']");
		this.buttonSearch = page.locator("//input[@name='btnK']");
	}
	
	public void searchGoogle(String text) {
		searchTermInput.fill(text);
//		pages.press("enter");
	}
	
	public void printToConsole() {
		System.out.println("HAI");
	}
	
	
}
