package pages;

import org.apache.log4j.Logger;
import org.apache.tika.metadata.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PropertyManager;

public class HomePage {
	private WebDriver driver;
	static PropertyManager propertyManager = new PropertyManager();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public YellowStoneSearch searchForYellowStone(String find) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("q"))));

		driver.findElement(By.name("q")).sendKeys(find);
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		wait = new WebDriverWait(driver, 20);
		return new YellowStoneSearch(driver);
	}
}
