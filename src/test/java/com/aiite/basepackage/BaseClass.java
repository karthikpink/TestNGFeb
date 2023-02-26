package com.aiite.basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static void browserLaunch(){
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	public static void loadUrl(String url){
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static String gurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public static String selectlocation(WebElement name,String value) {
		Select select=new Select(name);
		select.deselectByValue(value);
		return value;
	}
	
	
	public static String ExcelFile(String name) throws IOException{
			File file=new File("C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\GenerateData.xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook wk=new XSSFWorkbook(fis);
			Sheet sheet=wk.getSheet(name);
			String value=sheet.toString();
			return value;
	}
	public static String ExcelFile(String name,int rowNum,int columnNum) throws IOException{
		//	FacebookFilepath="C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\Facebook User details.xlsx";
		//	AmazonFilepath="C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\Amazon user details.xlsx";
		//	AdactinHotelFilepath="C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\Hotel details of Adactin.xlsx";
		//	CitiBankOffers="C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\citiBankOffers.xlsx";
		if(name.equals("FacebookUserDetails")) {
			File file=new File("C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\Facebook User details.xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook wk=new XSSFWorkbook(fis);
			Sheet sheet=wk.getSheet(name);
			Row row=sheet.getRow(rowNum);
			Cell cell=row.getCell(columnNum);
			String value=cell.getStringCellValue();
			return value;
		}
		   else if(name.equals("AmazonUserDetails")) {
			File file=new File("C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\Amazon user details.xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook wk=new XSSFWorkbook(fis);
			Sheet sheet=wk.getSheet(name);
			Row row=sheet.getRow(rowNum);
			Cell cell=row.getCell(columnNum);
			String value=cell.getStringCellValue();
			return value;
		}
		  else if(name.equals("AdactinUserDetails")) {
			File file=new File("C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\Hotel details of Adactin.xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook wk=new XSSFWorkbook(fis);
			Sheet sheet=wk.getSheet(name);
			Row row=sheet.getRow(rowNum);
			Cell cell=row.getCell(columnNum);
			String value=cell.getStringCellValue();
			return value;
		}
		  else if(name.equals("CitiBankDetails")){
				File file=new File("C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\citiBankOffers.xlsx");
				FileInputStream fis=new FileInputStream(file);
				Workbook wk=new XSSFWorkbook(fis);
				Sheet sheet=wk.getSheet(name);
				Row row=sheet.getRow(rowNum);
				Cell cell=row.getCell(columnNum);
				String value=cell.getStringCellValue();
				return value;
				}
		  else {
			File file=new File("C:\\Users\\VINOTH\\Desktop\\karthik\\Test Credentials\\GenerateData.xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook wk=new XSSFWorkbook(fis);
			Sheet sheet=wk.getSheet(name);
			Row row=sheet.getRow(rowNum);
			Cell cell=row.getCell(columnNum);
			String value=cell.getStringCellValue();
			return value;
			}
		}
		public static String Properties(String filepath,String key) throws IOException{
			File file=new File(filepath);
			FileInputStream fis=new FileInputStream(file);
			Properties pro=new Properties();
			pro.load(fis);
			String value=pro.getProperty(key);
			return value;
		}
		public static void screenShot(String name) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screenShotAs = ts.getScreenshotAs(OutputType.FILE);
			File screenShot=new File("C:\\Users\\VINOTH\\Desktop\\karthik\\Tested ScreenShot"+name+".png");
			FileHandler.copy(screenShotAs,screenShot);
		}
		public static void closeBrrowser() {
			driver.close();
		}
	}
