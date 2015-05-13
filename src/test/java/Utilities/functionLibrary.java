package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class functionLibrary {
	
	/**
         * To maximize the browser.
	 * @param driver
	 */
 
	public static void maximizeWindow(WebDriver driver){
		
		driver.manage().window().maximize();
		
	}
	
	/**
	 * @param driver is the firefox driver.
	 * @param element is web element to be scrolled.
	 */
	public static void scrollTo(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

}
