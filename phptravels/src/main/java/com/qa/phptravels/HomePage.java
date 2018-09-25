package com.qa.phptravels;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public abstract class HomePage {
 
	private final String HOME_TITLE = "Client Area - PHPTRAVELS";
	private final String HOME_URL = "Client Area - PHPTRAVELS";
	
	private final By EMAIL_ID = By.id("inputEmail");
	private final By PASSWORD_ID = By.id("inputPassword");
	private final By LOGIN_ID = By.id("login");
 
	private final By ERROR_MSG_XPATH = 
		By.xpath("//div[@class = 'alert alert-danger text-center']");	
	
	private WebDriver driver;
 
	public HomePage(WebDriver d) {
		this.driver = d;		
	}
	
	public void open() {
		driver.get(HOME_URL);
		if (driver.getTitle().equalsIgnoreCase(HOME_TITLE) == false)
			throw new RuntimeException(
				"Home page is not displayed.");
	}	
	
	public WelcomePage loginAndContinue(User user) {
		loginWith(user);
		return new WelcomePage(this.driver);
	}
	
	public void loginWith(User user) {
		WebElement emailTextBox = driver.findElement(EMAIL_ID);
		emailTextBox.sendKeys(user.email());
	
		WebElement passwordTextBox = driver.findElement(PASSWORD_ID);
		passwordTextBox.sendKeys(user.password());
	
		WebElement loginButton = driver.findElement(LOGIN_ID);
		loginButton.click();
	}
	
	public String incorrectLoginMsg() {
		WebElement errMsgElement = 	
						driver.findElement(ERROR_MSG_XPATH);
 
		return errMsgElement.getText().trim();
	}
	
	public String emailTooltip() {
		String toolTip = "function getTooltip() {" +
 "var tooltip=document.querySelector(\"input[id='inputEmail']\")
.validationMessage; return tooltip; };  abstract void getTooltip();
 
		JavascriptExecutor jsExec = (JavascriptExecutor)this.driver;
		return (String)jsExec.executeScript(toolTip);
	}
}