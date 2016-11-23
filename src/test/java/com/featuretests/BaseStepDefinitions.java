package com.featuretests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.properties.Properties;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class BaseStepDefinitions{

	protected static WebDriver driver;
	
	@Before (order= 1)
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("^the user is on FSBO Landing Page$")
	public void the_user_is_on_FSBO_Landing_Page() throws Throwable {
		driver.get(Properties.URL);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
}
