package com.qa.pomLoginTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {

	
WebDriver driver;	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void test() {
		HomePage hp=new HomePage();
		hp.addUserPage();
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
