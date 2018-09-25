package com.qa.phptravels;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class LoginPageTests {
		
	private String helloMessage = "Hello, %s!";
	
	private final String incorrectDetailsMsg = 
			"Login Details Incorrect. Please try again.";
	
	private String emailValidationError = 
			"Please include an '@' in the email address. " + 
			"'%s' is missing an '@'.";
	
	WebDriver driver;	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
			         "C:/Users/Admin/Desktop/chromedriver.exe");
 
		driver = new ChromeDriver();		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginWorks() {
		
		User user = new User("alexsiminiuc3@gmail.com", 			
							 "Password123!", 
							 "Alex");
		
		HomePage homePage = new HomePage(this.driver);
		homePage.open();
		WelcomePage welcomePage = homePage.loginAndContinue(user);
				
		String expectedMsg = String.format(helloMessage, 				
										   user.name());
				
		assertTrue("Hello message is not displayed!", 
				   welcomePage.welcomeMessage()
						.contains(expectedMsg));		
	}
	
	@Test
	public void loginFailsForIncorrectEmail() {
		
		User user = new User("alexsiminiuc2@gmail.com", 		
							 "Password123!", 
						     "Alex");
		
		HomePage homePage = new HomePage(this.driver);
		homePage.open();
		homePage.loginWith(user);
				
		assertTrue("Incorrect Details Message is not displayed!", 
				   homePage.incorrectLoginMsg()
		    			.equalsIgnoreCase(incorrectDetailsMsg));
		
	}
	
	@Test
	public void invalidEmailDoesNotWork() throws InterruptedException 			
	{		
		
		User user = new User("alexsiminiuc", 
							 "Password123!", 
							 "Alex");
		
		HomePage homePage = new HomePage(this.driver);
		homePage.open();
		homePage.loginWith(user);
										
	    String expectedError = String.format(emailValidationError, 	
											 user.email());		
		assertEquals(expectedError, homePage.emailTooltip());
					
	}
}