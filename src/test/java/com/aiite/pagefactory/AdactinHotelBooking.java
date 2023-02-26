package com.aiite.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aiite.basepackage.BaseClass;

public class AdactinHotelBooking extends BaseClass {
public AdactinHotelBooking() {
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//input[@id='username']")
public WebElement userName;

@FindBy(xpath="//input[@id='password']")
public WebElement passWord;

@FindBy(xpath="//input[@id='login']")
public WebElement logInBtn;

@FindBy(xpath="//select[@id='location']")
public WebElement locationDD;

@FindBy(xpath="//select[@id='hotels']")
public WebElement hotel;

@FindBy(xpath="//select[@id='room_type']")
public WebElement roomType;

@FindBy(xpath="//select[@id='room_nos']")
public WebElement noOfRooms;

@FindBy(xpath="//input[@id='datepick_in']")
public WebElement checkInDate;

@FindBy(xpath="//input[@id='datepick_out']")
public WebElement checkOutDate;

@FindBy(xpath="//select[@id='adult_room']")
public WebElement adultPerRoom;

@FindBy(xpath="//select[@id='child_room']")
public WebElement childPerRoom;

@FindBy(xpath="//input[@id='Submit']")
public WebElement searchBtn;

@FindBy(xpath="//input[@id='radiobutton_0']")
public WebElement radioBtn;

@FindBy(xpath="//input[@id='continue']")
public WebElement continueBtn;

@FindBy(xpath="//input[@id='first_name']")
public WebElement firstName;

@FindBy(xpath="//input[@id='last_name']")
public WebElement lastName;

@FindBy(xpath="//textarea[@id='address']")
public WebElement billingAddress;

@FindBy(xpath="//input[@id='cc_num']")
public WebElement ccNumber;

@FindBy(xpath="//select[@id='cc_type']")
public WebElement ccType;

@FindBy(xpath="//select[@id='cc_exp_month']")
public WebElement ccExpMonth;

@FindBy(xpath="//select[@id='cc_exp_year']")
public WebElement ccExpYear;

@FindBy(xpath="//input[@id='cc_cvv']")
public WebElement CVVNum;

@FindBy(xpath="//input[@id='book_now']")
public WebElement bookNowBtn;
}
