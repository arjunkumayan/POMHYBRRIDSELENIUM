package com.qa.labs.tests;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.labs.base.BasePage;
import com.qa.labs.base.BaseTest;
import com.qa.labs.listeners.ExtentReportListener;
import com.qa.labs.pages.LoginPage;
import com.qa.labs.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


//@Listeners(ExtentReportListener.class)

@Epic("Epic - 101: design login page with different features...")
@Story("US - 102: design basic login page with signup, title and login form")
public class LoginPageTest extends BaseTest {
//	WebDriver driver;
//	BasePage basePage;
//	LoginPage loginPage;
//	Properties  prop;
	
//	@BeforeTest
//	public void setUp() {
//		basePage = new BasePage();
//		prop = basePage.init_prop();
//		driver = basePage.init_driver(prop.getProperty("browser"));
//		loginPage = new LoginPage(driver);		
//	}
	
	@Test(priority=2)
	@Description("verifyLoginPageTitle")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"login page title is not displayed...");
		}
	
	
	
	@Test(priority=1)
	@Description("verifySignUlLinkTest")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUlLinkTest() {
		Assert.assertTrue(loginPage.verifyLogiSignUpLink(),"Sign up link is not displayed...");
	}
	
	@Test(priority=3)
	@Description("loginTest")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
//	
	
	
	

}
