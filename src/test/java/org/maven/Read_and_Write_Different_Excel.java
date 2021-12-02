package org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_and_Write_Different_Excel {

public static void main(String[] args) throws IOException  {
 
String readingFile = ("Read Excel File.xlsx");
String writingFile = ("Write Excel File.xlsx");
String readingSheet = ("Test Sheet");
String writingSheet = ("Written Sheet");

File fileRead = new File ("C:\\Users\\Bismillah\\Desktop\\Test Read\\"+readingFile);
FileInputStream input = new FileInputStream (fileRead);
Workbook readWorkbook = new XSSFWorkbook(input);
Sheet readSheet = readWorkbook.getSheet(readingSheet);

File fileWrite = new File ("C:\\Users\\Bismillah\\Desktop\\Test Write\\"+writingFile);
FileOutputStream output = new FileOutputStream(fileWrite);
Workbook writeWorkbook = new XSSFWorkbook();
Sheet writeSheet = writeWorkbook.createSheet(writingSheet);

for (int i = 0; i < readSheet.getPhysicalNumberOfRows(); i++) {
	Row row = readSheet.getRow(i);
	Row createRow = writeSheet.createRow(i);  
	
for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
Cell getCell = row.getCell(j);
Cell createCell = createRow.createCell(j);
int cellType = getCell.getCellType();

if (cellType==1) {
String stringCellValue = getCell.getStringCellValue(); 
createCell.setCellValue(stringCellValue);}

else if (DateUtil.isCellDateFormatted(getCell)) {
Date dateCellValue = getCell.getDateCellValue();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
dateFormat.format(dateCellValue);
createCell.setCellValue(dateCellValue);} 

else {double numericCellValue = getCell.getNumericCellValue();

long l = (long) numericCellValue ;
createCell.setCellValue(l); } } } 

writeWorkbook.write(output); 

System.out.println("Excel has been Read and Written Successfully");
System.out.println("Written File Available in below Path"+"\n"+fileWrite); } } 