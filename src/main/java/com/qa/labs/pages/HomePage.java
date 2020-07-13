package com.qa.labs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.labs.base.BasePage;
import com.qa.labs.util.Constants;
import com.qa.labs.util.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	//public ElementUtil elementUtil;
	
	By header = By.className("dashboard-selector__title");
	By accountMenuClick= By.id("account-menu");
	By userEmailName = By.className("user-info-email");
	By userName= By.className("user-info-name");
	
	
	//By primaryContactLink = By.id("nav-primary-contacts-branch");
	By primaryContactLink = By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]");
	By secondaryContactLink = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;	
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getHomePageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}
	
	public String getHomePageHeaderText() {
//		if(driver.findElement(header).isDisplayed()) {
//		return driver.findElement(header).getText();
//		}
		
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	public String getLoggedInUser() {
//		if(driver.findElement(accountMenuClick).isDisplayed()) {
//			driver.findElement(accountMenuClick).click();
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userEmailName));
//			return driver.findElement(userEmailName).getText();
//		}
		
		if(elementUtil.doIsDisplayed(accountMenuClick)) {
			elementUtil.doClick(accountMenuClick);
			return elementUtil.doGetText(userEmailName);
		}
		return null;
	}
	
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		//elementUtil.waitForElementToBeVisible(primaryContactLink, 20);
		elementUtil.doActionsClick(primaryContactLink);
		//elementUtil.doClick(primaryContactLink);
		elementUtil.waitForElementToBeVisible(secondaryContactLink, 5);
		elementUtil.doClick(secondaryContactLink);
	}
	
	
	
	
	

}
