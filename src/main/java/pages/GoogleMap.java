package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PropertyManager;

public class GoogleMap {
	private WebDriver driver;
	static PropertyManager propertyManager = new PropertyManager();

	public GoogleMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyMapURL() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String url = driver.getCurrentUrl();
		System.out.print("\n" + url + "\n");
		if (url.contains("map") && url.contains("Yellowstone"))
			return true;
		return false;
	}

}
