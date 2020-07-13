package com.qa.labs.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.labs.base.BaseTest;
import com.qa.labs.pages.ContactsPage;
import com.qa.labs.pages.HomePage;
import com.qa.labs.util.Constants;
import com.qa.labs.util.ExcelUtil;

public class ContactsPageTest extends BaseTest {
	
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeClass
	public void ContactsSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}
	
	@Test(priority=1)
	public void verifyContactsPageTitleTest() {
		
	String title = contactsPage.getContactsPageTitle();
	System.out.println("Contacts page title is: "+title);
	
	Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
//	@Test(priority=2)
//	public void createContactTest() {
//		contactsPage.createContact("anshul@gmail.com", "anshul", "sharma", "SDET1");
//	}

	
	
	@DataProvider
	public Object[][] getContactsTestData() {
		
		Object[][] data = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		
		return data;
		
	}
	
//	@Test(priority=2,dataProvider="getContactsTestData")
//	public void createContactTest(String email, String firstName,String lastName, String jobTitle) {
//		contactsPage.createContact(email, firstName, lastName, jobTitle);
//		
//	}
}
