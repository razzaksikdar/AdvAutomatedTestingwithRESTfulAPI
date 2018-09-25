package com.qa.phptravels;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class WelcomePage {
	private By HELLO_MESSAGE_XPATH = By.xpath("//li[@id = 'Secondary_Navbar-Account']/a[@class='dropdown-toggle']");
		
	private final WebDriver driver;
	
	public WelcomePage(WebDriver d) {
		this.driver = d;
	}
	
	public String welcomeMessage() {
		WebElement helloMessageElement = 	
				driver.findElement(HELLO_MESSAGE_XPATH);
 
		return helloMessageElement.getText();
	}
}