package com.test.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageObject{
	
	private WebDriver driver;
	
	@FindAll({@FindBy(css = "div.timeline-steps-step-count")})
    private List<WebElement> timeLineSteps;
	
	@FindBy(xpath = "//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'mix-btn_wide', ' ' ))]")
    private WebElement viewListingPackagesBtn;

	@FindAll({@FindBy(css = "h4.hdg.hdg_h2")})
	private List<WebElement> timeLineStepDescriptionTitle;
	
	@FindBy(css = ".stepsTabs-directionNav-nav_next")
    private WebElement stepTimeLineNextArrowBtn;
	
	@FindBy(css = ".stepsTabs-directionNav-nav_prev")
	private WebElement stepTimeLinePreviousArrowBtn;
	
	public HomePageObject(WebDriver driver){
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}
	
	public void clickViewListingPackagesBtn(){
		viewListingPackagesBtn.click();
	}
	
	public void clickStepTimeLineStepNumber(int stepNumber){
		timeLineSteps.get(stepNumber-1).click();
	}
	
	public String getStepDescriptionTitle(int stepNumber){
		System.out.println("Text is: " + timeLineStepDescriptionTitle.get(stepNumber-1).getText());
		return timeLineStepDescriptionTitle.get(stepNumber-1).getText();
	}
	
	public void clickStepTimeLineNextArrowBtn(){
		stepTimeLineNextArrowBtn.click();
	}

	public void clickStepTimeLinePreviousArrowBtn() {
		stepTimeLinePreviousArrowBtn.click();
	}
	
}
