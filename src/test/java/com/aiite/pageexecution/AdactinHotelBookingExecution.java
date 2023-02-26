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
import com.aiite.pagefactory.AdactinHotelBooking;

public class AdactinHotelBookingExecution {
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
		BaseClass.loadUrl(BaseClass.ExcelFile("AdactinUserDetails", 1, 0));
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

	@Test(dependsOnMethods = {"selectHotel"},groups = {"Smoke","Sanity"})
	public void hotelBooking() throws IOException {
		AdactinHotelBookingExecution ahb=new AdactinHotelBookingExecution();
		ahb.selectHotel();
		AdactinHotelBooking ah=new AdactinHotelBooking();
		ah.firstName.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 11));
		ah.lastName.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 12));
		ah.billingAddress.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 13));
		ah.ccNumber.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 14));
		ah.ccExpMonth.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 15));
		ah.ccExpYear.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 16));
		ah.CVVNum.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 17));
		ah.bookNowBtn.click();
		System.out.println("Hotel booking Test");
	}
	@Test(dependsOnMethods = {"searchHotel"},groups = {"sainty","Regression"})
	public void selectHotel() throws IOException {
		AdactinHotelBookingExecution ahe=new AdactinHotelBookingExecution();
		ahe.searchHotel();
		AdactinHotelBooking ah=new AdactinHotelBooking();
		ah.radioBtn.click();
		ah.continueBtn.click();	
		System.out.println("Hotel select Test");
	}
	@Test(dependsOnMethods = {"hotelLogin"},groups= {"Regression"})
	public void searchHotel() throws IOException {
		AdactinHotelBookingExecution ah=new AdactinHotelBookingExecution();
		ah.hotelLogin();
		AdactinHotelBooking ahb=new AdactinHotelBooking();
		ahb.locationDD.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 3));
		//ahb.locationDD.sendKeys(BaseClass.selectelement("London", "locationDD"));
		ahb.hotel.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 4));
		ahb.roomType.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 5));
		ahb.noOfRooms.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 6));
		ahb.checkInDate.clear();
		ahb.checkInDate.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 7));
		ahb.checkOutDate.clear();
		ahb.checkOutDate.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 8));
		ahb.adultPerRoom.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 9));
		ahb.childPerRoom.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 1, 10));
		ahb.searchBtn.click();
		System.out.println("Hotel search Test");
	}
	@Test(groups = {"Smoke","Regress"})
	public void hotelLogin() throws IOException {
		AdactinHotelBooking ab=new AdactinHotelBooking();
		ab.userName.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 2, 1));
		ab.passWord.sendKeys(BaseClass.ExcelFile("AdactinUserDetails", 2, 2));
		ab.logInBtn.click();
		System.out.println("Hotel Login Test");
	}
}
