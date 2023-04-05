package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ajina @ 22-03-2023
 * @see Used to maintain the reusable methods
 */
public class BaseClass {

	public static WebDriver driver;

	/**
	 * 
	 * @return String
	 * @see Used to get the project path
	 */

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	/**
	 * 
	 * @param browserType
	 * @see Used to launch different browser
	 */

	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
		/**
		 * @see Used to launch Url
		 */

	}

	public void enterApplnUrl(String url) {
		driver.get(url);
	}

	/**
	 * 
	 * @see Used to maximize the tab
	 */

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @see Used to send text in webelement box
	 */
	public void elementSendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	/**
	 * 
	 * @param element
	 * @see Used to click the button in WebPage
	 */
	public void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * 
	 * @return String
	 * @see Used to get the title of the WebPage
	 */
	public String getApplnTittle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * 
	 * @param attributeValue
	 * @return WebElement
	 * @see Used to find the locator in id
	 */

	public WebElement findElementByID(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
	}

	/**
	 * 
	 * @param attributeValue
	 * @return WebElement
	 * @see Used to find the locator in name
	 */

	public WebElement findElementByName(String attributeValue) {
		WebElement findElement = driver.findElement(By.name(attributeValue));
		return findElement;
	}

	/**
	 * 
	 * @param attributeValue
	 * @return WebElement
	 * @see Used to find the locator in className
	 */
	public WebElement findElementByClassName(String attributeValue) {
		WebElement findElement = driver.findElement(By.className(attributeValue));
		return findElement;
	}

	/**
	 * 
	 * @param xpathExp
	 * @return WebElement
	 * @see Used to find the locator in xpath
	 */

	public WebElement findElementByXpath(String xpathExp) {
		WebElement findElement = driver.findElement(By.xpath(xpathExp));
		return findElement;
	}

	/**
	 * 
	 * @return String @ Used to get the current url of the WebPage
	 */
	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @see Used to get the text from WebPage
	 */

	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * 
	 * @param element
	 * @param attributeName
	 * @return String
	 * @see Used to get the value from the attributeName
	 */
	public String getAttributeValue(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @see Used to get the value from the value
	 */
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	/**
	 * 
	 * @param element
	 * @param attributeValue
	 * @see Used to select from value
	 */

	public void selectByValue(WebElement element, String attributeValue) {
		Select select = new Select(element);
		select.selectByValue(attributeValue);
	}

	/**
	 * 
	 * @param element
	 * @param index
	 * @see Used to select from index
	 */

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see Used to send text by Java Script
	 */
	public void elementSendkeysjs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}

	public void elementClickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	/**
	 * @see Used to accept the alert
	 */
	public void alertOk() {
		driver.switchTo().alert().accept();
	}

	/**
	 * @see Used to cancel the alert
	 */
	public void alertCancel() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * @see Used to close all tab in webpage
	 */

	public void quitWindow() {
		driver.quit();
	}

	/**
	 * @see Used to close the current
	 */

	public void windowClose() {
		driver.close();
	}

	/**
	 * 
	 * @param element
	 * @see Used to click in the webpage by using Java Script
	 */

	public void elementSendkeysjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	/**
	 * 
	 * @param name
	 * @see Used to switch window from parent window tpo child window
	 */
	public void switchChildWindow(String name) {
		driver.switchTo().window(name);
	}

	/**
	 * 
	 * @param index
	 * @see Used to switch from onne frame to another frame by using index
	 */
	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * @param index
	 * @see Used to switch from onne frame to another frame by using locator
	 */

	public void switchFrameByIndex(String data) {
		driver.switchTo().frame(data);
	}

	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see Used to get all option in drop down
	 */
	public List<WebElement> allOptionDropdown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement opt = options.get(i);
			String text = opt.getText();
		}
		return options;

	}

	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see Used to get the all option in dropdown as attribute
	 */

	public List<WebElement> allOptionDropdownAsAttribute(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement opt = options.get(i);
			String text = opt.getAttribute("value");
		}
		return options;

	}

	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see Used to first selected option
	 */

	public List<WebElement> firstSelectedOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		WebElement opt = options.get(5);
		String text = opt.getText();
		return options;
	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see Used to know it is multiple or not
	 */
	public boolean multiSelectOption(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	/**
	 * 
	 * @param element
	 * @param index
	 * @see Used to deselect by index
	 */

	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * 
	 * @param element
	 * @param value
	 * @see Used to deselect by attribute
	 */

	public void deselectByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see Used to deselect by text
	 */

	public void deselectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @see Used to deselect all
	 */

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @return String
	 * @see Used to get parent window
	 */

	public String getParentWindow(WebElement element, String text) {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @return Set<String>
	 * @see Used to get all window
	 */

	public Set<String> getAllWindow(WebElement element, String text) {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	/**
	 * 
	 * @param element
	 * @see Used to clear the text box
	 */

	public void clearTextbox(WebElement element) {
		element.clear();
	}

	/**
	 * 
	 * @param element
	 */

	public void mouseOverActionForSingleOption(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * 
	 * @param element
	 * @see Used to Drag and drop(copy and paste)
	 */
	public void dragAndDrop(WebElement element) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element).perform();
	}

	/**
	 * 
	 * @param element
	 * @Used to perform right click
	 */
	public void contentClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * 
	 * @param element
	 * @see Used to double click a text inn webpage
	 */

	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * @see Used to refresh the webPage
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * 
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 * @see Used to update a data in the excel
	 */

	public void updateCellData(String sheetname, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\ajina\\eclipse-workspace\\MavenProject\\ExcelSheet\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * 
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 * @see Used to write the data in excel
	 */
	public void writeCellData(String sheetname, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\ajina\\eclipse-workspace\\MavenProject\\ExcelSheet\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws IOException
	 * @see Used to read the data from the the excel
	 * 
	 */
	public String readCellData(String sheetName, int rowNum, int cellNum) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\ajina\\eclipse-workspace\\MavenProject\\ExcelSheet\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				res = format.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}

			break;
		default:
			break;
		}
		return res;

	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @see Used to Send the text and press enter key
	 */

	public void elementWithEnterKey(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);

	}

	/**
	 * @see Used to implicity wait
	 */
	public void implicityWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see Used to get property file value
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	/**
	 * @see Used to switch default frame
	 */
	public void switchDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @param element
	 * @see Used to switch by element
	 */
	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * 
	 * @param index
	 * @see Used to switch by index
	 */
	public void switchFrameByInd(int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see Used to select visible text
	 */
	public void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * 
	 * 
	 * @param element
	 * @see Used to Move to element
	 */
	public void actionByClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).clickAndHold();
	}

	/**
	 * 
	 * @param element
	 * @see Used to wait
	 */
	public void waituntill(WebElement element) {
		WebDriverWait button = new WebDriverWait(driver, Duration.ofSeconds(3000));
		button.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * 
	 * @param element
	 * @see Used to Send keys with enter key
	 */
	public void sendKeysbyEnter(WebElement element) {

		element.sendKeys(Keys.ENTER);
	}

	/**
	 * 
	 * @return byte[]
	 * @throws InterruptedException 
	 * @see Used to take screenshot
	 */
	public byte[] sreenShot() throws InterruptedException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		Thread.sleep(5000);
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
	}
}
