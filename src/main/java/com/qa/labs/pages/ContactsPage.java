package com.qa.labs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.labs.base.BasePage;
import com.qa.labs.util.Constants;
import com.qa.labs.util.ElementUtil;

public class ContactsPage extends BasePage {
	
	private WebDriver driver;
	
	By header = By.xpath("//i18n-string[text()='Contacts']");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobtitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[last()]");
	
	By ContactsBackClick = By.xpath("(//*[text()='Contacts'])[position()=1]");
	
	
	public ContactsPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_HEADER, 10);
		
	}
	
	public String getContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}
	
	
	public void createContact(String email, String firstName,String lastName,String jobTitle) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
//		elementUtil.waitForElementToBeVisible(createContactPrimary, 20);
//		elementUtil.doClick(createContactPrimary);
//		
//		
//		elementUtil.waitForElementToBeVisible(email1, 20);
//		elementUtil.doSendKeys(email1, email);
//		elementUtil.doSendKeys(firstName1, firstName);
//		elementUtil.doSendKeys(lastName1, lastName);
//		
//		elementUtil.waitForElementToBeVisible(jobtitle1, 5);
//		elementUtil.doSendKeys(this.jobtitle, jobTitle);
//		
//		elementUtil.clickWhenReady(createContactSecondary, 10);
//		
//		elementUtil.doClick(ContactsBackClick);
		
		elementUtil.clickWhenReady(createContactPrimary, 20);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.doSendKeys(this.jobtitle, jobTitle);

		elementUtil.doActionsClick(createContactSecondary);
		elementUtil.clickWhenReady(ContactsBackClick, 20);
		//elementUtil.doActionsClick(ContactsBackClick);
	}
	
	
	

}
