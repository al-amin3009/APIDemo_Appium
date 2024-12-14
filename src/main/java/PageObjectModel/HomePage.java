package PageObjectModel;

import org.openqa.selenium.WebElement;

import BasePage.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage{

	public HomePage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public WebElement NavigateToViewsPage(String text) {
		return scrollToElement(text);
	}
}
