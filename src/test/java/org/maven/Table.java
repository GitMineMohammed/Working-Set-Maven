package org.maven;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

public static void main(String[] args) throws AWTException {

System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Selenium_Tasks\\Driver\\chromedriver.exe");	

WebDriver driver=new ChromeDriver(); 
driver.get("https://www.espncricinfo.com/series/ipl-2021-1249214/points-table-standings");
driver.manage().window().maximize();

//To Locate Table
WebElement table = driver.findElement(By.tagName("table"));

//To Locate Heading
WebElement heading = table.findElement(By.tagName("thead"));

//To Locate Heading Row
WebElement headingRow = heading.findElement(By.tagName("tr"));

//To Locate Multiple Heading Elements
List<WebElement> headings = headingRow.findElements(By.tagName("th"));

//Iterate the Heading
for (int i = 0; i < headings.size(); i++) {
	WebElement headingElements = headings.get(i);
	String text = headingElements.getText();
	System.out.print(text+"   "+"\t");}

//-----------------------------------------------------------------------------------------------------

//To Locate Content
WebElement content = table.findElement(By.tagName("tbody"));

//To Locate Multiple Rows
List<WebElement> multipleRows = content.findElements(By.tagName("tr"));

//Iterate the Individual Row
for (int i = 0; i < multipleRows.size(); i++) {
	WebElement individualRow = multipleRows.get(i);
	
//To Locate Multiple Elements present in Each Row
	List<WebElement> individualElements = individualRow.findElements(By.tagName("td"));
	
//Iterate IndividualElements
for (int j = 0; j < individualElements.size(); j++) {
	WebElement element = individualElements.get(j);
String text = element.getText();
System.out.print(text+"\t"); } }

driver.quit();} }