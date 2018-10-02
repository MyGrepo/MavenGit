import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class reusableKeywords {
	static WebDriver myD;
	
	public static void typeText(String vEID, String vTD){
		// Purpose : Clear and Type a value in a Text Edit field in a web browser.
		// Inputs : EID, Test Data
		// Outputs : N/A
		myD.findElement(By.xpath(vEID)).clear();
		myD.findElement(By.xpath(vEID)).sendKeys(vTD);
	}
	
	public static String verifyText(String vEID, String vText){
		// Purpose : Verify the text in a Text Element in a web browser.
		// Inputs : EID, Text to verify
		// Outputs : Pass or Fail
		String vActualText;
		vActualText = myD.findElement(By.xpath(vEID)).getText();
		if(vActualText.equals(vText)){
			return "Pass";
		} else {
			return "Fail";
		}
	}
	
	public static void openBrowser(String vBrowser){
		// Purpose : Sets the driver system path and launches that specific browser
		// Inputs : Browser Name
		// Outputs : N/A
		if (vBrowser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prasanta Naik\\Desktop\\SeleniumLT\\Drivers\\chromedriver.exe");
			myD = new ChromeDriver();	
		}
		if (vBrowser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prasanta Naik\\Desktop\\SeleniumLT\\Drivers\\geckodriver.exe");
			myD = new FirefoxDriver();	
		}
		myD.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public static void navigateBrowser(String vURL){
		// Purpose : Navigates a Web Browser to a URL
		// Inputs : AUT URL
		// Outputs : N/A
		myD.get(vURL);
	}
	
	public static void closeBrowser(){
		// Purpose : Navigates a Web Browser to a URL
		// Inputs : AUT URL
		// Outputs : N/A
		myD.quit();
	}
	
	public static void clickButton(String vEID){
		// Purpose : Clicks on a button
		// Inputs : xPath
		// Outputs : N/A
		myD.findElement(By.xpath(vEID)).click();
	}
	public static void clickLink(String vEID){
		// Purpose : Clicks on a button
		// Inputs : xPath
		// Outputs : N/A
		myD.findElement(By.partialLinkText(vEID)).click();
		
	}

}
