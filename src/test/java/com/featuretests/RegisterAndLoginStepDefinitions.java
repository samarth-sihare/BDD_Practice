package com.featuretests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.test.pageobject.HomePageObject;
import com.test.pageobject.LoginPageObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterAndLoginStepDefinitions {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;

	public RegisterAndLoginStepDefinitions() {
		this.driver = BaseStepDefinitions.driver;

		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
	}

	@Given("^he navigates to register page$")
	public void he_navigates_to_register_page() throws Throwable {
		homePage.clickSignInBtn();
		loginPage.clickDontHaveAnAccountLink();
	}

	@When("^user tries to create account with email as \"([^\"]*)\"$")
	public void user_tries_to_create_account_with_email_as(String email) throws Throwable {
		loginPage.enterEmailAddress(email);
	}

	@When("^he enters the password as \"([^\"]*)\" and confirms the password as \"([^\"]*)\"$")
	public void he_enters_the_password_as_and_confirms_the_password_as(String password, String confirmPassowrd)
			throws Throwable {
		loginPage.enterPassword(password);
		loginPage.enterConfirmPassword(confirmPassowrd);
	}

	@When("^selects role as \"([^\"]*)\"$")
	public void selects_role_as(String role) throws Throwable {
		loginPage.selectUserRoleRadioBtns(role);
	}

	@When("^requests to register$")
	public void requests_to_register() throws Throwable {
		 loginPage.clickRegisterBtn();
	}

	@Then("^he should (?:see|not see) validation message for \"([^\"]*)\"$")
	public void he_should_see_validation_message_for(String validOrInvalid) throws Throwable {
		String actualValidationMessage = loginPage.getRegistartionFormValidationMessage();
		
		//Follwonig are the expected validation messages 
		String invalidEmailValidationMessage = "The Email field must contain a valid email address.";
		String missingEmailValidationMessage = "The Email field is required.";
		String mandatoryEmailValidationMessage = "The Email field is required.";
		
		//Conditions to handle all the messages (may need to add more)
		if (validOrInvalid.equalsIgnoreCase("invalidEmail")) {
			Assert.assertEquals("The Error message is not as expected", invalidEmailValidationMessage,actualValidationMessage);
		}
		
		if (validOrInvalid.equalsIgnoreCase("requiredEmail")) {
			Assert.assertEquals("The Error message is not as expected", invalidEmailValidationMessage,actualValidationMessage);
		}
		
		else if (validOrInvalid.equalsIgnoreCase("validEmail")){
			if(loginPage.isValidationMessageDisplayed()){
				Assert.assertFalse("Invalid email validation message is not expected", actualValidationMessage.contains(invalidEmailValidationMessage));
				Assert.assertFalse("Invalid email validation message is not expected", actualValidationMessage.contains(missingEmailValidationMessage));
			}
		}
			
	}

}
