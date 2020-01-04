package com.cucumber.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver getBrowser(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Arun Gokul\\eclipse-workspace\\selenium\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\Arun Gokul\\eclipse-workspace\\selenium\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Arun Gokul\\eclipse-workspace\\selenium\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				throw new Exception("Invalid browser name");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Issue in browser launch");
		}
	}

	// url get
	public static void getUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("URL Is not valid");
		}
	}

	// for thread.sleep
	public static void waitForElementVisiblity(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	// clear in text box
	public static void clearValuesinElement(WebElement element) throws Exception {
		try {
			element.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	// sendkeys
	public static void inputValuestoElement(WebElement element, String values) throws Exception {
		try {
			waitForElementVisiblity(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				clearValuesinElement(element);
				element.sendKeys(values);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// click
	public static void clickOntheElement(WebElement element) throws Exception {
		try {
			waitForElementVisiblity(element);
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	// Mouse Hover
	public static void moveTOtheElement(WebElement element) throws Exception {
		try {
			waitForElementVisiblity(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	// drop down select
	public static void DropDown(WebElement element, String options, String values) throws Exception {
		waitForElementVisiblity(element);
		Select sc = new Select(element);
		if (options.equalsIgnoreCase("index")) {
			sc.selectByIndex(Integer.parseInt(values));
		} else if (options.equalsIgnoreCase("value")) {
			sc.selectByValue(values);
		} else if (options.equalsIgnoreCase("visibletext")) {
			sc.selectByVisibleText(values);
		} else {
			throw new Exception("Not a valid options");
		}
	}

	// scroll by element
	public static void scrollToElement(WebElement element) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	// screenshot
	public static void takeScreenShot(String name) throws IOException {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("C:\\Users\\Arun Gokul\\Desktop\\java files\\sc example\\" + name + ".png");
			FileUtils.copyFile(temp, des);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// window handles
	public static void switchToWindows(int index) throws Exception {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(windowHandles);
			String winID = li.get(index);
			driver.switchTo().window(winID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}
	/*
	 * public static int getText(WebElement element) throws Exception { int
	 * textvalue=0; try { String s =element.getText(); textvalue =
	 * Integer.parseInt(s);
	 * 
	 * } catch (NumberFormatException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); throw new Exception(); } return textvalue; }
	 */

	public static int getValuesText(WebElement element) {
		int amt=0;
		try {
			String s = element.getText();
			if (s.contains("AUD")) {
				String replace1 = s.replace("AUD","").trim();
				s = replace1;
				amt= Integer.parseInt(replace1);
			} else if (s.contains("$")) {
				String replace2 = s.replace("$","").trim();
				s=replace2;
				amt = Integer.parseInt(replace2);
			} else if (s.contains("Days")) {
				String replace3 = s.replace("Days","").trim();
				s=replace3;
				amt = Integer.parseInt(replace3);
			} else if (s.contains("Rooms")) {
				String replace4 = s.replace("Rooms","").trim();
				s=replace4;
				amt = Integer.parseInt(replace4);
			}
			System.out.println(s);
		}

		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return amt;
	}

	public static void highlightElement(WebElement element) throws Throwable 
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid blue;');", element);
		} catch (Exception e) {
			throw new Exception("element is not highlited");
		}
	}

	public static String getexcelData(String sheet, int row, int cell) throws Throwable {
		String x = null;
		try {
			File f = new File("C:\\Users\\Arun Gokul\\eclipse-workspace\\MavenProctise\\excel\\Book1.xlsx");
			FileInputStream f1 = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(f1);
			Sheet s = w.getSheet(sheet);

			int rowcount = s.getPhysicalNumberOfRows();
			System.out.println(rowcount);

			Row row1 = s.getRow(row);
			Cell cell1 = row1.getCell(cell);

			switch (cell1.getCellType()) {
			case NUMERIC:
				double d = cell1.getNumericCellValue();
				int a = (int) d;
				x = String.valueOf(a);
				System.out.println(x);
				break;

			case STRING:
				x = cell1.getStringCellValue();
				System.out.println(x);
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

}
