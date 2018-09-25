package com.qa.pomLoginTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	public static WebElement loginLink;
	
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	public static WebElement addUser; 
	
	
	public void addUserPage() {
		
		addUser.click();
		
	}

	
	public void addLoginPage() {
		
		loginLink.click();
		
	}

	
}
