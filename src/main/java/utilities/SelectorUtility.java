package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;



public  class SelectorUtility {

	public static void selectSingleNBSP(List<WebElement> lis, String val1) {
		 for(WebElement lisvals : lis) {
				
			 String dayrec = lisvals.getText();
		
			 if(dayrec.equals(val1+" ")) {
			
				 lisvals.click();
			 }
		 }
		
	}
	
	public static void selectDoubleNBSP(List<WebElement> lis, String val1) {
		 for(WebElement lisvals : lis) {
				
			 String dayrec = lisvals.getText();
		
			 if(dayrec.equals(val1+" "+" ")) {
			
				 lisvals.click();
			 }
		 }
	}
	
	public static void selectNONBSP(List<WebElement> lis, String val1) {
		
		for(WebElement lisvals:lis) {
			String listext = lisvals.getText();
			if(listext.equals(val1)) {
				lisvals.click();
			}
			
		}
		
	}
	
}
