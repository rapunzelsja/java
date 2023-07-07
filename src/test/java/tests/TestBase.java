package tests;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.tika.metadata.Property;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyManager;
//import utilities.RotateLog4j;
//import utilities.WriteDataToFile;

public class TestBase {

	protected static Hashtable<String, String> htable = new Hashtable<String, String>();
	protected static WebDriver driver;
	static PropertyManager propertyManager = new PropertyManager();
	private static Logger logger = Logger.getLogger(Property.class.getName());

	// static String browsername = propertyManager.getProperty("BASE_URL");;
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	static ExtentTest test;
	static ExtentReports extent;
	String log4jConfPath = "./resources/log4j.properties";

	@BeforeMethod
	public static void setDriver() {
		String currentDirectory = System.getProperty("user.dir");
		logger.info("Browser Session Started");

		// TODO add more browsers coverage
		System.out.println("user.dir: " + currentDirectory);
		WebDriverManager.getInstance(CHROME).setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.get(propertyManager.getProperty("BASE_URL"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log(" ", true);
		Reporter.log("Application Started", true);
		logger.info("Application Started");

	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void teardownTest() throws IOException {
		logger.info("Tear down test");
		SessionId session = ((ChromeDriver) driver).getSessionId();
		logger.info("Session id: " + session.toString());
		driver.manage().deleteAllCookies();
		driver.close();
		logger.info("Browser closed");
		driver.quit();
		logger.info("Browser Session Ended");
	}

	@AfterMethod
	public void takeScreenShot(ITestResult testResult) throws IOException {
		Reporter.setCurrentTestResult(testResult);
		if (testResult.getStatus() == ITestResult.FAILURE) {
			snapScreenShot("failure", testResult.getName());
		}
	}

	private void snapScreenShot(String status, String name) throws IOException {
		// Copy to ScreenshotReport
		String fileWithPath = System.getProperty("user.dir") + "\\" + propertyManager.getProperty("screenshotsdir")
				+ "\\" + status + "_" + name;
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		// logger.info("<br><img src ='" + fileWithPath + "' height='400'/><br>"
		// );
	}

	public void extentFlush() {
		TestBase.extent.flush();
	}

	public static void turnOnImplicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void turnOffImplicitWait() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void extentTestFailure(String path) throws IOException {
		System.out.println("Inside second screenshot method");
	}

	public static String getProperty(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
