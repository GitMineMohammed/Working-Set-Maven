package org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel_Using_Physical_Value {

public static void main(String[] args) throws InterruptedException, IOException {

File file = new File ("E:\\Eclipse\\Maven_First_Project\\Test Data\\Test Excel File.xlsx");
FileInputStream fIS = new FileInputStream(file);

//Create Object for Excel
Workbook w = new XSSFWorkbook(fIS);

//Get Sheet from Obj.ref of Workbook
Sheet sheet = w.getSheet("Adactin");   //--> Sheet Name
			
//Get No. of Rows filled With Data
int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
System.out.println(physicalNumberOfRows);

//Iterate Each Row from Rows
for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
Row row = sheet.getRow(i);
			
//Iterate Cells from Row
for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
Cell cell = row.getCell(j);

//To find Type of Type of Data
int cellType = cell.getCellType();

if (cellType==1) {
	String stringCellValue = cell.getStringCellValue();
System.out.println(stringCellValue+" "+"\t");}

else {
	double numericCellValue = cell.getNumericCellValue();
	System.out.println(numericCellValue);

//Type Cast since	
long l = (long)numericCellValue;
System.out.println(l); 

} } } } }