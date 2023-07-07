package smoke.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.GoogleMap;
import pages.HomePage;
import pages.YellowStoneSearch;
import tests.TestBase;
import utilities.PropertyManager;
import utilities.TimeStampTool;

public class googleHomeTest extends TestBase {
	static PropertyManager propertyManager = new PropertyManager();
	
	@Test()
	public void checkSearchInputField() throws InterruptedException, IOException, SQLException {

		HomePage hp = new HomePage(driver);
		YellowStoneSearch ys = new YellowStoneSearch(driver);
		GoogleMap gm = new GoogleMap(driver);
		
		String find = "Yellowstone map";
		
		Logger.getLogger(getClass().getName()).log(Level.INFO, "Reading Property " + "BASE_URL");
		Reporter.log("Verify Goggle search for Yelowstone map " + TimeStampTool.getCurrentDateTimeUS(), true);

		ys = hp.searchForYellowStone(find);
		assertTrue(ys.verifyMapButtonVisible());
		Reporter.log("Search results loaded", true);
		
		Reporter.log("Verify Search results ", true);
		gm = ys.verifySearchResults();
		assertTrue(gm.verifyMapURL());
		
		Reporter.log("Verify search contains Yellowstone related results ", true);
	}
}
