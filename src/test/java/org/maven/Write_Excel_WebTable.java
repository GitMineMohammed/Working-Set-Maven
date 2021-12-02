package org.maven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Write_Excel_WebTable {

public static void main(String[] args) throws IOException  {

//File , Workbook should not be created above system property but should be after Finding WebElents
System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Selenium_Tasks\\Driver\\chromedriver.exe");	

WebDriver driver=new ChromeDriver(); 
driver.get("https://www.google.com/search?q=ipl+2021+points+table&oq=&aqs=chrome.3.35i39i362l4j46i39i362j35i39i362l3.106795788j0j7&sourceid=chrome&ie=UTF-8#cobssid=s");
//driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();

File filePath = new File("C:\\Users\\Bismillah\\Desktop\\Test Folder\\Write Excel File.xlsx");

Workbook workBook = new XSSFWorkbook();
Sheet createSheet = workBook.createSheet("Write Sheet");
//Row createRow = createSheet.createRow(0);

WebElement table = driver.findElement(By.tagName("table"));

//WebElement head = table.findElement(By.tagName("thead"));
//WebElement headRow = head.findElement(By.tagName("tr"));
//List<WebElement> heading = headRow.findElements(By.tagName("th"));
//
//for (int i = 0; i < heading.size(); i++) {
//	Cell createCell = createRow.createCell(i);
//	WebElement headingData = heading.get(i);
//	String text = headingData.getText();
//	createCell.setCellValue(text);}

//===================================================================================================================

WebElement body = table.findElement(By.tagName("tbody"));
List<WebElement> bodyRows = body.findElements(By.tagName("tr"));


for (int i = 0; i < bodyRows.size(); i++) {
	Row createRows = createSheet.createRow(i+1);
	WebElement bodyRow = bodyRows.get(i);
List<WebElement> bodyDatas = bodyRow.findElements(By.tagName("td"));	

for (int j = 0; j < bodyDatas.size(); j++) {
	WebElement bodyData = bodyDatas.get(j);
	Cell createCell = createRows.createCell(j);
	String text = bodyData.getText();
	createCell.setCellValue(text); } }

FileOutputStream fileOutput = new FileOutputStream(filePath);
workBook.write(fileOutput); 

driver.quit();} } 