package com.aiite.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiite.basepackage.BaseClass;

public class CitiBankOffers extends BaseClass{
public CitiBankOffers() {
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@title='Close']")
public WebElement popUpClose;

@FindBy(xpath="//span[text()='Refer and Earn']")
public WebElement referAndEarn;

@FindBy(xpath="//a[text()='NO']")
public WebElement ccAndSavingsAcc;
}
