package PageObjectModel;

import org.openqa.selenium.WebElement;

import BasePage.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class ViewPage extends BasePage{

	public ViewPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement NavigateToPage(String pageName) {
		return scrollToElement(pageName);
	}

}
