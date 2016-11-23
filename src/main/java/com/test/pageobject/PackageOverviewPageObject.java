package com.test.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PackageOverviewPageObject {
	
	private WebDriver driver;
	
	@FindBy(name = "postalCode")
    private WebElement zipCodeTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement zipCodeSubmitBtn;
	
	@FindBy(css = ".link_sm")
	private WebElement outSideUSorCanadaHyperlink;
	
	@FindBy(css = ".packageTable-row-cell:nth-child(1) .mix-hdg_bold")
	private WebElement firstPackageColumnTitle;
	
	@FindBy(css = ".packageTable-row-cell:nth-child(2) .mix-hdg_bold")
	private WebElement secondPackageColumnTitle;
	
	@FindBy(css = ".packageTable-row-cell:nth-child(3) .mix-hdg_bold")
	private WebElement thirdPackageColumnTitle;

	@FindAll({@FindBy(css = ".packageTable-row-cell:nth-child(3) .mix-hdg_bold")})
	private static List<WebElement> thirdPackageColumnTitleList;

	@FindBy(css = ".packageTable-row-cell:nth-child(4) .mix-hdg_bold")
	private WebElement fourthPackageColumnTitle;
	
	@FindAll({@FindBy(css = ".packageTable-row-cell:nth-child(4) .mix-hdg_bold")})
	private static List<WebElement> fourthPackageColumnTitleList;
	
	public PackageOverviewPageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterZipCode(String zipCode){
		zipCodeTextBox.clear();
		zipCodeTextBox.sendKeys(zipCode);
	}
	
	public void clickHyperlinkOutsideUSorCanada(){
		outSideUSorCanadaHyperlink.click();
	}

	public void clickZipCodeSubmitBtn(){
		zipCodeSubmitBtn.click();
	}
	
	public String firstPackageColumnTitleText(){
		return firstPackageColumnTitle.getText();
	}
	
	public String secondPackageColumnTitleText(){
		return secondPackageColumnTitle.getText();
	}
	
	public String thirdPackageColumnTitleText(){
		return thirdPackageColumnTitle.getText();
	}
	
	public String fourthPackageColumnTitleText(){
		return fourthPackageColumnTitle.getText();
	}
	
	public Boolean isThirdPackageDisplayed(){
		return !thirdPackageColumnTitleList.isEmpty();
	}
	
	public Boolean isFourthPackageDisplayed(){
		return !fourthPackageColumnTitleList.isEmpty();
	}

	public void assertColumnPackageName(String columnNumber, String expectedColumntitleText, String actualColumntitleText){
		Assert.assertEquals("Expected " + columnNumber + " column package listing is '" + expectedColumntitleText + "' but was '" + actualColumntitleText + "'", expectedColumntitleText, actualColumntitleText);
	}
	
}
