package com.aiite.pageexecution;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.CitiBankOffers;

public class CitiBankOffersExecution {
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
		BaseClass.loadUrl(BaseClass.ExcelFile("CitiBankDetails", 1, 0));
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
	@Test(groups = {"Smoke"})
	public void closePopup() {
		CitiBankOffers cb=new CitiBankOffers();
		cb.popUpClose.click();
		cb.referAndEarn.click();
		cb.ccAndSavingsAcc.click();
		System.out.println("test 1");
	}
}
