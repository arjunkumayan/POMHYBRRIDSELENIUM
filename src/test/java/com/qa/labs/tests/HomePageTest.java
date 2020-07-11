package com.qa.labs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.labs.base.BasePage;
import com.qa.labs.pages.HomePage;
import com.qa.labs.pages.LoginPage;
import com.qa.labs.util.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;	
	HomePage homePage;
	Properties prop;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop.getProperty("browser"));
		loginPage = new LoginPage(driver);
		//homePage= new HomePage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	
	@Test(priority=3)
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,"Home page title is not matched...");
	}
	
	@Test(priority=2)
	public void verifyHomePageHeader() {
		String homePageHeaderText = homePage.getHomePageHeaderText();
		System.out.println("Home page header is: "+homePageHeaderText);
		Assert.assertEquals(homePageHeaderText, Constants.HOME_PAGE_HEADER,"Home page header is not matched..");
	}
	
	@Test(priority=1)
	public void verifyLoggedInUserText() {
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in user email id is: "+loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountName"),"Logged in user is not matched");
		}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
