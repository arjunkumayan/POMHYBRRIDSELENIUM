package com.qa.labs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.labs.base.BasePage;

public class HomePage extends BasePage {
	
	WebDriver driver;
	By header = By.className("dashboard-selector__title");
	By accountMenuClick= By.id("account-menu");
	By userEmailName = By.className("user-info-email");
	By userName= By.className("user-info-name");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;		
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeaderText() {
		if(driver.findElement(header).isDisplayed()) {
		return driver.findElement(header).getText();
		}
		return null;
	}
	
	public String getLoggedInUser() {
		if(driver.findElement(accountMenuClick).isDisplayed()) {
			driver.findElement(accountMenuClick).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userEmailName));
			return driver.findElement(userEmailName).getText();
		}
		return null;
	}
	
	
	
	
	

}
