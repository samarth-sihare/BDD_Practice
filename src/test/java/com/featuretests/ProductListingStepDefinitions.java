package com.featuretests;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.test.pageobject.HomePageObject;
import com.test.pageobject.PackageOverviewPageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductListingStepDefinitions  {
	
	private WebDriver driver;
	private HomePageObject homePage;
	private PackageOverviewPageObject packageOverviewPage;
	
	public ProductListingStepDefinitions(){
		this.driver = BaseStepDefinitions.driver;
		
		homePage = new HomePageObject(driver);
		packageOverviewPage  = new PackageOverviewPageObject(driver);
		
	}
	
	@Given("^he navigates to view listing packages$")
	public void he_navigates_to_view_listing_packages() throws Throwable {
	    homePage.clickViewListingPackagesBtn();
	}

	@When("^he enters \"([^\"]*)\" as zip code$")
	public void he_enters_as_zip_code(String zipCode) throws Throwable {
		packageOverviewPage.enterZipCode(zipCode);
	}

	@When("^submits the request to view package listing$")
	public void submits_the_request_to_view_package_listing() throws Throwable {
		packageOverviewPage.clickZipCodeSubmitBtn();
	}

	@When("^he navigates to Lising Packages Outside US or Canada$")
	public void he_navigates_to_Lising_Packages_Outside_US_or_Canada() throws Throwable {
		packageOverviewPage.clickHyperlinkOutsideUSorCanada();
	}
	
	@Then("^he is able to view Free Listing package in first column$")
	public void he_is_able_to_view_Free_Listing_package_in_first_column() throws Throwable {
		String actualColumntitleText = packageOverviewPage.firstPackageColumnTitleText(); 
		packageOverviewPage.assertColumnPackageName("first", "FREE", actualColumntitleText);
	}

	@Then("^he is able to view MLS Enhanced package in fourth column$")
	public void he_is_able_to_view_MLS_Enhanced_package_in_fourth_column() throws Throwable {
		String actualColumntitleText = packageOverviewPage.fourthPackageColumnTitleText();
		packageOverviewPage.assertColumnPackageName("fourth", "MLSENHANCED", actualColumntitleText);
	}

	@Then("^he is able to view Multi-Media package in third column$")
	public void he_is_able_to_view_Multi_Media_package_in_third_column() throws Throwable {
		String actualColumntitleText = packageOverviewPage.thirdPackageColumnTitleText();
		packageOverviewPage.assertColumnPackageName("third", "MULTI-MEDIA", actualColumntitleText);
	}
	
	//these are the step Definitions for data driven test
	@Then("^he is able to view \"([^\"]*)\" Listing package in first column$")
	public void he_is_able_to_view_Listing_package_in_first_column(String expectedColumntitleText) throws Throwable {
		String actualColumntitleText = packageOverviewPage.firstPackageColumnTitleText(); 
		packageOverviewPage.assertColumnPackageName("first", expectedColumntitleText, actualColumntitleText);
	}
	
	@Then("^he is able to view \"([^\"]*)\" Listing package in second column$")
	public void he_is_able_to_view_Listing_package_in_second_column(String expectedColumntitleText) throws Throwable {
		String actualColumntitleText = packageOverviewPage.secondPackageColumnTitleText(); 
		packageOverviewPage.assertColumnPackageName("second", expectedColumntitleText, actualColumntitleText);
	}

	@Then("^he is able to view \"([^\"]*)\" Listing package in third column$")
	public void he_is_able_to_view_Listing_package_in_third_column(String expectedColumntitleText) throws Throwable {
		if (expectedColumntitleText.equalsIgnoreCase("does not exist")){
	    	//TODO May want to create a new Scenario to avoid this or leave it blank or make some assertion
			System.out.println(packageOverviewPage.isThirdPackageDisplayed().toString());
	    	Assert.assertFalse("Fourth Column Exists but is not expected to be.", packageOverviewPage.isThirdPackageDisplayed());
	    }
	    else{
		String actualColumntitleText = packageOverviewPage.thirdPackageColumnTitleText(); 
		packageOverviewPage.assertColumnPackageName("third", expectedColumntitleText, actualColumntitleText);
	    }
	}

	@Then("^he is able to view \"([^\"]*)\" Listing package in fourth column$")
	public void he_is_able_to_view_Listing_package_in_fourth_column(String expectedColumntitleText) throws Throwable {
	    if (expectedColumntitleText.equalsIgnoreCase("does not exist")){
	    	System.out.println(packageOverviewPage.isFourthPackageDisplayed().toString());
	    	Assert.assertFalse("Fourth Column Exists but is not expected to be.", packageOverviewPage.isFourthPackageDisplayed()); 
	    }
	    else{
	    	String actualColumntitleText = packageOverviewPage.fourthPackageColumnTitleText(); 
	    	packageOverviewPage.assertColumnPackageName("fourth", expectedColumntitleText, actualColumntitleText);
	    }
	    	
	}
	
}
