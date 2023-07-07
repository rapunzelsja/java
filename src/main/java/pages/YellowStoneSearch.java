package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PropertyManager;

public class YellowStoneSearch {

	private WebDriver driver;
	static PropertyManager propertyManager = new PropertyManager();

	@FindBy(xpath = "//*/div[5]/div/div/div[1]/div[1]/div/a[2]")
	private WebElement googleMapButton;

	public YellowStoneSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyMapButtonVisible() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(googleMapButton));
		if (googleMapButton.isDisplayed()) {
			return true;
		}
		return false;
	}

	public GoogleMap verifySearchResults() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(googleMapButton));
		googleMapButton.click();
		wait = new WebDriverWait(driver, 40);
		return new GoogleMap(driver);
	}
}
