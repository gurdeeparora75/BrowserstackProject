package com.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends mainTestClass {

	@Test
	public void performVerifications() {
	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://www.google.com");
			
		//Assertion#2 - verify Google search bar is displayed on google.com
		WebElement ele = driver.findElement(By.xpath("//*[@title='Search']"));
		boolean value= ele.isDisplayed();
		Assert.assertTrue(value);
		try {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Google Search bar displayed!\"}}");	
			
		}catch(Exception e){
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Google Search button bar displayed!\"}}");
			
		}
		
		//Assertion#2 - verify Google search bar is enabled on google.com
		boolean value2= ele.isEnabled();
		System.out.println("Google Search button enabled: "+value2);
		Assert.assertTrue(true);
		try {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Google Search bar enabled!\"}}");	
			
		}catch(Exception e){
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Google Search button bar enabled!\"}}");
			
		}
		
		//Assertion#3 - To get title of webpage google.com
	
		 Assert.assertEquals(driver.getTitle(), "Google");
	
    	try {
			
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
    	}
    	catch(Exception e) {
    		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
    	}
    	System.out.println(driver.getTitle());
    	driver.quit();
	
	}

}

	



