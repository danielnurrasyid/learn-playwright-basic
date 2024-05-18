
import com.microsoft.playwright.*;
import resources.HandleElements;


public class Demo {
    public static void main(String[] args) {
    	
    	Playwright playwright = Playwright.create();
    	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    	Page page = browser.newPage();
    	HandleElements handleElement = new HandleElements(page);
    	page.navigate("https://www.google.com");
    	handleElement.searchGoogle("playwright");
    	handleElement.printToConsole();
    	browser.close();
    	playwright.close();
        
    }
}