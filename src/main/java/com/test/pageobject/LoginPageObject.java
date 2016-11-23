package com.test.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
//	private WebDriver driver;
	
	@FindBy(linkText = "Don't have an Account?")
	private WebElement DontHaveAnAccountLink;
	
	@FindBy(name = "szEmail")
	private WebElement emailAddressTxtBox;
	
	@FindBy(name = "szPassword")
	private WebElement passwordTxtBox;
	
	@FindBy(name = "szPassword2")
	private WebElement confirmPasswordTxtBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement registerBtn;
	
	@FindBy(xpath = "//*[@id='registrationForm']/div[5]/label[1]")
	private WebElement userRoleSeller;
	
	@FindBy(xpath = "//*[@id='registrationForm']/div[5]/label[2]")
	private WebElement userRoleBuyer;
	
	@FindBy(className = "//*[@id='registrationForm']/div[5]/label[3]")
	private WebElement userRoleBoth;
	
	@FindAll({@FindBy(xpath = "//div[@id='registrationError']/ul/li")})
	private List<WebElement> registrationFormValidationMessages; 
	
//	@FindAll({@FindBy(xpath = "//div[@id='registrationError']/ul")})
//	private List<WebElement> registrationFormValidationMessage; 
	
	public LoginPageObject(WebDriver driver){
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDontHaveAnAccountLink(){
		DontHaveAnAccountLink.click();
	}
	
	public void enterEmailAddress(String email){
		emailAddressTxtBox.sendKeys(email);
	}
	
	public void enterPassword(String password){
		passwordTxtBox.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword){
		confirmPasswordTxtBox.sendKeys(confirmPassword);
	}
	
	public void clickRegisterBtn(){
		registerBtn.click();
	}
	
	public void selectUserRoleRadioBtns(String role){
		if (role.equalsIgnoreCase("seller"))
			userRoleSeller.click();
		else if (role.equalsIgnoreCase("Buyer"))
			userRoleBuyer.click();
		else if (role.equalsIgnoreCase("both"))
			userRoleBoth.click();
//		else
//			Assert.fail("The Value of user role should be 'seller' or 'buyer' or 'both'");
	}
	
	public String getRegistartionFormValidationMessage(){
		StringBuilder messages = new StringBuilder();
		
		for(WebElement validationMessage : registrationFormValidationMessages){
			messages.append(validationMessage.getText());
//			messages.append(" ");
		}
//		return messages.toString().trim();
		return messages.toString();
		
	}
	
	public Boolean isValidationMessageDisplayed(){
		return !registrationFormValidationMessages.isEmpty();
	}
}
