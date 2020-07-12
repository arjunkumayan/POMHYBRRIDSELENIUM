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
		elementUtil.waitForElementToBeVisible(createContactPrimary, 10);
		elementUtil.doClick(createContactPrimary);
		
		
		elementUtil.waitForElementToBeVisible(this.email, 5);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		
		elementUtil.waitForElementToBeVisible(this.jobtitle, 5);
		elementUtil.doSendKeys(this.jobtitle, jobTitle);
		
		elementUtil.clickWhenReady(createContactSecondary, 10);
		
	}
	
	
	

}
