package com.featuretests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.test.pageobject.HomePageObject;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SellingStepsTimeLineStepDefinitions{
	
	private WebDriver driver;
	private HomePageObject homePage;
	
	public SellingStepsTimeLineStepDefinitions(){
		this.driver = BaseStepDefinitions.driver;
		
		homePage = new HomePageObject(driver);
	}
	
	@When("^user (?:navigates to|is on) step number \"(.*)\" on step time line$")
	public void user_navigates_to_step_number_on_step_time_line(int stepNumber) throws Throwable {
	    homePage.clickStepTimeLineStepNumber(stepNumber);
	}

	@Then("^he should be able to see details as \"([^\"]*)\" for step \"(.*)\"$")
	public void he_should_be_able_to_see_details_as_for_step(String expectedTitle, int stepNumber) throws Throwable {
		String actualTitle = homePage.getStepDescriptionTitle(stepNumber);
		Assert.assertEquals("Expected Step Title is '" + expectedTitle + "' but was '" + actualTitle + "'", expectedTitle, actualTitle);
	}
	
	@When("^he navigates using (.*) arrow button$")
	public void he_navigates_using_next_arrow_button(String navigationArrow) throws Throwable {
		
		if (navigationArrow.equalsIgnoreCase("next"))
			homePage.clickStepTimeLineNextArrowBtn();
		else if (navigationArrow.equalsIgnoreCase("previous"))
			homePage.clickStepTimeLinePreviousArrowBtn();
	}

}
