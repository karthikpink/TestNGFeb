package com.aiite.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiite.basepackage.BaseClass;

public class FacebookLoginPage extends BaseClass {
	public FacebookLoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	public WebElement userName;

	@FindBy(id="pass")
	public WebElement passWord;

	@FindBy(xpath="//button[@name='login']")
	public WebElement logInBtn;

	@FindBy(xpath="//a[text()='Messenger']")
	public WebElement messenger;

	@FindBy(xpath="//input[@id='email']")
	public WebElement msngrId;

	@FindBy(xpath="//input[@id='pass']")
	public WebElement msngrPass;

	@FindBy(xpath="//button[@id='loginbutton']")
	public WebElement msngrLogInBtn;

	@FindBy(xpath="//a[text()='Features']")
	public WebElement features;
}

