package org.jun;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void WindowsMaximazer() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String Url) {
		driver.get(Url);
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageUrl() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl;
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys("txt");
	}

	public static void clckBtn(WebElement ele) {
		ele.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("Location+ imgName.png");
		FileUtils.copyFile(image, f);
	}

	public static Actions a;

	public static void MovetoElement(WebElement targetElement) {
		a = new Actions(driver);
		a.moveToElement(targetElement).perform();
	}

	public static void DragandDrop(WebElement dragElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragElement, dropElement);
	}

	public static Robot r;

	public static void keyPress() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
	}

	public static JavascriptExecutor js;

	public static void scrollThepage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView('true')", tarWebEle);
	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("Excel Location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row r = sheet.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();

				if (cellType == 1) {
					String value1 = c.getStringCellValue();
					System.out.println(value1);
				}

				else if (DateUtil.isCellDateFormatted(c)) {
					Date dd = c.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd-MMM-YY");
					String value2 = s.format(dd);
					System.out.println(value2);
				}

				else {
					double num = c.getNumericCellValue();
					long l = (long) num;
					String value3 = String.valueOf(l);
					System.out.println(value3);
				}
			}
		}
	}

	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\Deepak\\Documents\\BaseClass\\Excel\\newSheet.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet("Datas");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}
	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\Deepak\\Documents\\BaseClass\\Excel\\newSheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createCell(int getRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\Deepak\\Documents\\BaseClass\\Excel\\newSheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(getRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updateDataToPartcularCell(String exisitingData, int getTheCell, int getTheRow,
			String writeNewData) throws IOException {
		File f = new File("C:\\Users\\Deepak\\Documents\\BaseClass\\Excel\\newSheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook e = new XSSFWorkbook(fis);
		Sheet mySheet = e.getSheet("Datas");
		Row r = mySheet.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(exisitingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		e.write(fos);
	}
}
