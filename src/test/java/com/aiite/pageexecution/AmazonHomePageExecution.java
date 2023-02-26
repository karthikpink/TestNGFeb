package com.aiite.pageexecution;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.AmazonHomePage;

public class AmazonHomePageExecution {
	@BeforeSuite(alwaysRun=true)
	public static void beforeSuite() {
		System.out.println("Before Suite Method");
	}
	
	@BeforeGroups(alwaysRun=true)
	public static void beforeGroup() {
		System.out.println("Before Group Method");
	}
	
	@AfterSuite(alwaysRun=true)
	public static void afterSuite() {
		System.out.println("After Suite Method");
	}
	
	@AfterGroups(alwaysRun=true)
	public static void afterGroup() {
		System.out.println("After Group Method");
	}
	
	@BeforeClass(alwaysRun=true)
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeTest(alwaysRun=true)
	public static void beforeTest() {
		System.out.println("Before Test");
	}
	
	@BeforeMethod(alwaysRun=true)
	public static void beforeMethod() throws IOException {
		BaseClass.browserLaunch();
		BaseClass.loadUrl(BaseClass.ExcelFile("AmazonUserDetails", 1, 0));
		System.out.println("Before Method");
	}
	
	@AfterClass(alwaysRun=true)
	public static void AfterClass() {
		System.out.println("After Class");
	}
	
	@AfterTest(alwaysRun=true)
	public static void afterTest() {
		System.out.println("After Test");
	}
	
	@AfterMethod(alwaysRun=true)
	public static void afterMethod() {
		BaseClass.closeBrrowser();
		System.out.println("After Method");
	}
	@Test(groups= {"Sanity"})
	public void validLoginDetails() throws IOException {
		AmazonHomePage ap=new AmazonHomePage();
		ap.signIn.click();
		ap.userName.sendKeys(BaseClass.ExcelFile("AmazonUserDetails", 2, 1));
		ap.continueBtn.click();
		ap.passWord.sendKeys(BaseClass.ExcelFile("AmazonUserDetails", 2, 2));
		ap.logInBtn.click();
		System.out.println("Login test");
	}
	@Test(dependsOnMethods = "validLoginDetails",priority=2,groups= {"Sanity"})
	public void amazonCart() throws IOException {
		AmazonHomePageExecution ahp=new AmazonHomePageExecution();
		ahp.validLoginDetails();
		AmazonHomePage ap=new AmazonHomePage();
		ap.cart.click();
		System.out.println("cart clicked");
	}
	@Test(dependsOnMethods = "validLoginDetails",priority=1,groups= {"Smoke","Sanity"})
	public void giftCard() throws IOException {
		AmazonHomePageExecution ahp=new AmazonHomePageExecution();
		ahp.validLoginDetails();
		AmazonHomePage ap=new AmazonHomePage();
		ap.giftCards.click();
		System.out.println("Gift card clicked");
	}
	@Test(priority=-1,groups= {"Regression","Sanity"})
	public void todayDeals() {
		AmazonHomePage ap=new AmazonHomePage();
		ap.todayDeals.click();
		System.out.println("Todays Deals clicked");
	}
}
