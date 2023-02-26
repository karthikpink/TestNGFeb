package com.aiite.pageexecution;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.FacebookLoginPage;

public class FacebookLoginPageExecution {
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
		BaseClass.loadUrl(BaseClass.ExcelFile("FacebookUserDetails", 1, 0));
		System.out.println("Before Method");
	}
	@DataProvider(name="testData",parallel=true)
	public Object[][] generateData() {
		return new Object[][] {
			{"azharudeen", "abc123"},
			{"manivannan", "welcome@3"},
			{"praveen", "Test@12"},
			{"kumar", "automate@12"},
			{"Naveen", "java@67"}
			};	
	}
	@Test(dataProvider ="testData",groups={"Smoke"},priority=1)//,
	public void facebookLoginMethod(String userName,String passWord) throws IOException, InterruptedException {
		FacebookLoginPage fb=new FacebookLoginPage();
		fb.userName.sendKeys(userName);
		fb.passWord.sendKeys(passWord);
		fb.logInBtn.click();
		//Thread.sleep(3000);
		System.out.println("Facebook Login Test");
	}
	@Test(priority=-1,groups= {"Smoke"})
	public void MsngrLoginMethod() throws IOException {
		FacebookLoginPage fb=new FacebookLoginPage();
		fb.messenger.click();
		fb.msngrId.sendKeys(BaseClass.ExcelFile("FacebookUserDetails", 2, 1));
		fb.msngrPass.sendKeys(BaseClass.ExcelFile("FacebookUserDetails", 2, 2));
		System.out.println("Messenger Login Test");
	}
	@Test(dependsOnMethods="MsngrLoginMethod",groups= {"Smoke"})
	public void featuresMethod() {
		FacebookLoginPage fb=new FacebookLoginPage();
		fb.messenger.click();
		fb.features.click();
		System.out.println("Features Test");
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
}
