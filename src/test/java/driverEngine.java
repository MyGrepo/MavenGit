import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class driverEngine {
	
	// This class contains all reusable KW Functions
	
	// Define global/class objects/variables
	static WebDriver myD;
	
	public static void main(String[] args) throws Exception{
		
		String[][] xTC, xTS; // 2D Arrays that will hold the excel content
		String xlPath = "C:\\Users\\Prasanta Naik\\Desktop\\SeleniumLT\\AnyAut_KDF.xls";
		int tcRows, tcCols, tsRows, tsCols;
		
		String vTCID, vTCDesc, vTCExecute;
		String vTSTCID, vTSID, vTSDesc, vKW, vEID, vTD;
		
				
		// Read the 2 excel sheets
		xTC = xlMethods.readXL(xlPath, "TestCases");
		xTS = xlMethods.readXL(xlPath, "TestSteps");
		
		tcRows = xTC.length;
		tcCols = xTC[0].length;
		tsRows = xTS.length;
		tsCols = xTS[0].length;
		
		System.out.println("TC Rows are : " + tcRows);
		System.out.println("TC Cols are : " + tcCols);
		System.out.println("TS Rows are : " + tsRows);
		System.out.println("TS Rows are : " + tsCols);
		
		// Go to each Test Case in the Excel
		for(int i = 1; i<tcRows; i++){
			//  
			vTCID = xTC[i][0];     
			vTCDesc = xTC[i][1]; 
			vTCExecute = xTC[i][2]; 
			// vTCResult = xTC[i][3]; 
			if (vTCExecute.equals("Y")){ // If selected (Y) for execution,
				// then go to each test step
				for(int j = 1; j<tsRows; j++) {
					vTSTCID = xTS[j][0]; 
					vTSID = xTS[j][1]; 
					vTSDesc = xTS[j][2]; 
					vKW = xTS[j][3]; 
					vEID = xTS[j][4]; 
					vTD = xTS[j][5]; 
					// vTSResult = xTS[j][6]; 
					// Match it with the current Test Case ID
					if (vTCID.equals(vTSTCID)){
						// Get KW and Inputs
						System.out.println("TCID is " + vTCID);
						System.out.println("KW is " + vKW);
						System.out.println("EID is " + vEID);
						System.out.println("TestData is " + vTD);
						// Thread.sleep(3000);
						
						// Call the corresponding KW Function
						
						try {
							if (vKW.equals("openBrowser")){
								reusableKeywords.openBrowser(vTD);
							}
							if (vKW.equals("closeBrowser")){
								reusableKeywords.closeBrowser();
							}
							if (vKW.equals("navigateBrowser")){
								reusableKeywords.navigateBrowser(vTD);
							}
							if (vKW.equals("typeText")){
								reusableKeywords.typeText(vEID, vTD);
							}
							if (vKW.equals("verifyText")){
								reusableKeywords.verifyText(vEID, vTD);
							}
							if (vKW.equals("clickButton")){
								reusableKeywords.clickButton(vEID);
							}
							if (vKW.equals("clickLink")){
								reusableKeywords.clickLink(vEID);
							}
						} catch (Exception myError){
							System.out.println("Error occurred : " + myError);
						} 
					
						// Execute till end of TS and TC
						// Handle Expected and Unexpected Errors
					}
					
				}
				
			}
		}
			
	}
	

}
