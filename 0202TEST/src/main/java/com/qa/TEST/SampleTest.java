package com.qa.TEST;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://formy-project.herokuapp.com/keypress");
	WebElement element=driver.findElement(By.id("name"));
		element.click();
		element.sendKeys("raz");
		
		WebElement button=driver.findElement(By.id("button"));
		button.click();
		
		driver.quit();
	}


}
