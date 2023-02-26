package com.aiite.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiite.basepackage.BaseClass;

public class AmazonHomePage extends BaseClass{
	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	public WebElement signIn;
	
	@FindBy(linkText ="Today's Deals")
	public WebElement todayDeals;

	@FindBy(id="ap_email")
	public WebElement userName;

	@FindBy(xpath="//input[@id='continue']")
	public WebElement continueBtn;

	@FindBy(id="ap_password")
	public WebElement passWord;

	@FindBy(id="signInSubmit")
	public WebElement logInBtn;
	
	@FindBy(xpath="//a[text()='Gift Cards']")
	public WebElement giftCards;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	public WebElement cart;
}
