package com.tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class mainTestClass {
		
	WebDriver driver;
	
	public static final String USERNAME = "gurdeepkaurarora_a1AtYr";
	public static final String AUTOMATE_KEY = "3XSs9xBpocEsdQhoFCDN";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Parameters({"browser", "browser_version", "os", "os_version"})
	@BeforeMethod
	public void setUp(String browserName, String browser_version, String os, String os_version,  Method name) {

		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();
		
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability("os", os);
		caps.setCapability("os_version", os_version);
		caps.setCapability("browser_version", browser_version);
		caps.setCapability("name", methodName);

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
