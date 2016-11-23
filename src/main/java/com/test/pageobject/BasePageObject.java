package com.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {
	
	WebDriver driver;
	
	@FindBy(className = "sign-in-button")
	private WebElement signInBtn;
	
	public BasePageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignInBtn(){
		signInBtn.click();
	}
	

}
