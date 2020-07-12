package com.qa.labs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.labs.base.BasePage;
import com.qa.labs.util.Constants;
import com.qa.labs.util.ElementUtil;

public class LoginPage extends BasePage{
	
	private WebDriver driver; // only for Login page,, don't want to change this driver
	//public ElementUtil elementUtil;
	
	//1. By locators -- OR
	
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	
	//2. Create Constructor.. of Page class:
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(this.driver);
		
	}
	
	//3. page actions:
	
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
		
	public boolean verifyLogiSignUpLink() {		
		//return driver.findElement(signUpLink).isDisplayed();
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	public HomePage doLogin(String username,String password) {
//		driver.findElement(this.username).sendKeys(username);
//		driver.findElement(this.password).sendKeys(password);
//		driver.findElement(this.loginBtn).click();
		
		elementUtil.waitForElementToBeVisible(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(loginBtn);
		
		return new HomePage(driver);
	}
	
	
	

}
