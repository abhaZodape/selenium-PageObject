package org.seleniumhq.selenium.selenium_java;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.HomePage;
import Utilities.*;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
   /* *//**
     * Create the test case
     *
     * @param testName name of the test case
     *//*
    public AppTest( String testName )
    {
        super( testName );
    }

    *//**
     * @return the suite of tests being tested
     *//*
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    *//**
     * Rigourous Test :-)
     *//*
    public void testApp()
    {
        assertTrue( true );
    }*/
    
    private static WebDriver driver;
	private static final String BASE_URL = "https://www.o2.co.uk/";
	private static String textFromUI;
	
	@BeforeMethod
	public static void beforeMethod(){

		 driver = null;
		
	   textFromUI = null;
		
	}
	
	@Test
	public void testApp1() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		
		
		HomePage.link_Help(driver).click();
		Iterator<WebElement> itr = HomePage.getSubMenu(driver).iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().getAttribute("href"));
			System.out.println(itr.next().getText());
		}
		
	    
		HomePage.contactUs(driver).click();
		functionLibrary.maximizeWindow(driver);
		HomePage.technicalQuestionLink(driver).click();
		HomePage.selectionLink(driver).click();
		HomePage.payandGoLink(driver).click();
		functionLibrary.scrollTo(driver, HomePage.openingTimes(driver));
		textFromUI = HomePage.openingTimes(driver).getText();
		System.out.println("The text we get"+textFromUI);
		try{
			Assert.assertEquals(textFromUI, "Opening times");
			System.out.println("The actual text"+textFromUI+"expected text"+"Opening times");
		}catch(Exception e){
			System.out.println("The actual text"+textFromUI+"not equal to expected text"+"Opening times");
		}
		
	}
	
	@AfterMethod
	public void quitDriver(){
		driver.quit();
	}
}
