package org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Read_Excel_Using_Physical_Value_For_Table {

public static void main(String[] args) throws InterruptedException, IOException {

File file = new File ("C:\\Users\\Bismillah\\Desktop\\Test Folder\\Test Excel File.xlsx");

FileInputStream fIS = new FileInputStream(file);
Workbook w = new XSSFWorkbook(fIS);
Sheet sheet = w.getSheet("Test Sheet");

for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
Row row = sheet.getRow(i);

for (int j = 0; j < args.length; j++) {	
Cell cell = row.getCell(0);
} }




 } }