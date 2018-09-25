package com.qa.razzak.automatedChromeP;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

public class AutoCase {
	
	private String path= "C:/Users/Admin/Desktop/chromedriver.exe"; 
	private String driverKey = "wbdriver.chrome.driver";
	private String url= "http://thedemosite.co.uk/";
	ChromeDriver driver; 

	@Before
	public void setup() {
		System.getProperty(driverKey, path);
	}
	

	@Test
	public void methodTest() {
		driver.get(url);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	
}
