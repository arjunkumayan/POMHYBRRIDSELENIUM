package com.qa.labs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.labs.base.BasePage;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	
	//1. By locators -- OR
	
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	
	//2. Create Constructor.. of Page class:
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	//3. page actions:
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
		
	public boolean verifyLogiSignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username,String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginBtn).click();
		return new HomePage(driver);
	}
	
	
	

}
