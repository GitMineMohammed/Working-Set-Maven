package org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel_For_Adactin_Automation {

public static void main(String[] args) throws InterruptedException, IOException {

String fileName = ("Read Excel File");
String readingSheet = ("Adactin Booking");

File file = new File ("C:\\Users\\Bismillah\\Desktop\\Test Read\\"+fileName+".xlsx");
FileInputStream fIS = new FileInputStream(file);

//Create Object for Excel
Workbook w = new XSSFWorkbook(fIS);

//Get Sheet from Obj.ref of Workbook
Sheet sheet = w.getSheet(readingSheet);   //--> Sheet Name
					
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

System.out.println("Excel has been Read and Done the Task Successfully");
} } } } }