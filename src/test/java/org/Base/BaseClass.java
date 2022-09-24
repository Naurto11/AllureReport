package org.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static Actions a;

	public static Robot r;

	public static JavascriptExecutor js;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

	}

	public static void passUrl(String url) {

		driver.get(url);

	}

	public static void maxBrowser() {

		driver.manage().window().maximize();

	}

	public static void toInput(WebElement element, String input) {

		element.clear();
		element.sendKeys(input);

	}

	public  static void btnClick(WebElement element) {

		element.click();
		

	}

	public static void radioBtnclick(WebElement element) {

		element.submit();
	}

	public static void entireBrowser() {

		driver.quit();

	}

	public static void closebrowser() {
		driver.close();

	}

	public static void printText(WebElement element) {

		System.out.println(element.getText());

	}

	public static void getValue(WebElement element) {

		System.out.println(element.getAttribute("value"));

	}

	public static void printUrl() {

		System.out.println(driver.getCurrentUrl());

	}

	public static void printTitle() {

		System.out.println(driver.getTitle());

	}

	public static void toPerformMouseHoverAction(WebElement element) {

		a = new Actions(driver);

		a.moveToElement(element).perform();

	}

	public static void toPerformEnter() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void toPerformTabs() {

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public static void toPerformDragandDrop(WebElement src, WebElement des) {

		a.dragAndDrop(src, des);

	}

	public static void rightClick() {

		a.contextClick().perform();

	}

	public static void doubleClick(WebElement element) {

		a.doubleClick(element);

	}

	public static void toGetSingleWindowId() {

		driver.getWindowHandle();

	}

	public static void toGetMultipleWindowId() {

		driver.getWindowHandles();
	}

	public static void toSwitchoverBtnWindows(String name) {

		driver.switchTo().window(name);

		
	}
	
	
	
	

	public static void javaScriptsetAttribute(WebElement element, String name) {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('value','name')", element);

	}
	public static void javaScriptgetAttribute(WebElement element, String name) {
		
		js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].getAttribute('value',name')", element);

	}

	public static void quickInteractionPrintText(WebElement element, String name) {

		js.executeScript("arguments[0].getAttribute('value','name')", element);

		
	}

	public static void quickInteractionClick(WebElement btnclick) {
		js.executeScript("arguments[0].click()", btnclick);

	}
	
	
		

	public static String excelRead(int row, int cell ) throws IOException {

		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Testng6\\src\\data\\JMSA.xlsx");

		FileInputStream f1 = new FileInputStream(file);

		Workbook w = new XSSFWorkbook(f1);

		
		Sheet s1 = w.getSheet("Sheet1");

		Row r = s1.getRow(row);

		Cell c = r.getCell(cell);

		int cellType = c.getCellType();

		String value;

		if (cellType == 1) {

			value = c.getStringCellValue();

		}

		else if (DateUtil.isCellDateFormatted(c)) {

			Date d = c.getDateCellValue();

			SimpleDateFormat s2 = new SimpleDateFormat("dd-mm-yyyy");

			value = s2.format(d);

		} else {
			double dd = c.getNumericCellValue();

			long l = (long) dd;

			value = String.valueOf(l);
		}
		return value;

	}
	public static String excelWrite(int rowtoWrite, int celltoWrite, String valuetoBeWritten ) throws IOException {
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\TestNg7\\src\\data1\\testng.xlsx");
//		System.out.println("baseclass"+ rowtoWrite);
//		
//		System.out.println("baseclass"+  celltoWrite);
//
//		System.out.println("baseclass"+  valuetoBeWritten);


		 FileInputStream inputStream = new FileInputStream(file);
	        
	        //creating workbook instance that refers to .xls file
	        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
	        
	        //creating a Sheet object
	        XSSFSheet sheet=wb.getSheet("Sheet1");
      
//	        System.out.println("baseclass " +  sheet );

		

	//	Row r = sheet.getRow(rowtoWrite);

	//	Cell c = r.getCell(celltoWrite);
		  XSSFCell cell = sheet.getRow(rowtoWrite).createCell(celltoWrite);
		//int cellType = c.getCellType();

		//String value = valuetoBeWritten;
cell.setCellValue(valuetoBeWritten);

FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\TestNg7\\src\\data1\\testng.xlsx");

wb.write(fos);
fos.close();
return valuetoBeWritten;
	}
	
	
	

	public static String excelReadGeneral(int row, int cell ) throws IOException {

		File file1 = new File("C:\\Users\\Admin\\eclipse-workspace\\TestNg7\\src\\data1\\testng.xlsx");

		FileInputStream f2 = new FileInputStream(file1);

		Workbook w = new XSSFWorkbook(f2);

		
		Sheet s2 = w.getSheet("Sheet1");

		Row r1 = s2.getRow(row);

		Cell c1 = r1.getCell(cell);

		int cellType = c1.getCellType();

		String value;

		if (cellType == 1) {

			value = c1.getStringCellValue();

		}

		else if (DateUtil.isCellDateFormatted(c1)) {

			Date d = c1.getDateCellValue();

			SimpleDateFormat s3 = new SimpleDateFormat("dd-mm-yyyy");

			value = s3.format(d);

		} else {
			double dd = c1.getNumericCellValue();

			long l = (long) dd;

			value = String.valueOf(l);
		}
		return value;
	}
	public static String excelWriteGeneral(int rowtoWrite, int celltoWrite, String valuetoBeWritten ) throws IOException {
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\TestNg7\\src\\data1\\testng.xlsx");
//		System.out.println("baseclass"+ rowtoWrite);
//		   
//		System.out.println("baseclass"+  celltoWrite);
//
//		System.out.println("baseclass"+  valuetoBeWritten);


		 FileInputStream inputStream = new FileInputStream(file);
	        
	        //creating workbook instance that refers to .xls file
	        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
	        
	        //creating a Sheet object
	        XSSFSheet sheet=wb.getSheet("Sheet1");
      
//	        System.out.println("baseclass " +  sheet );

		

	//	Row r = sheet.getRow(rowtoWrite);

	//	Cell c = r.getCell(celltoWrite);
		  XSSFCell cell = sheet.getRow(rowtoWrite).createCell(celltoWrite);
		//int cellType = c.getCellType();

		//String value = valuetoBeWritten;
cell.setCellValue(valuetoBeWritten);

//FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\Testng5\\src\\data1\\Book1.xlsx");
//
//wb.write(fos);
//fos.close();
return valuetoBeWritten;
	}


}
