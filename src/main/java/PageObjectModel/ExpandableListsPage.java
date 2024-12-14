package PageObjectModel;

import org.openqa.selenium.WebElement;

import BasePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpandableListsPage extends BasePage{
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"People Names\"]")
    private WebElement peopleNamesItem;

    @AndroidFindBy(id = "android:id/content")
    private WebElement sampleActionPopup;

    public ExpandableListsPage(AndroidDriver driver) {
        super(driver);
    }
    
    public WebElement selectCustomAdapter(String text) {
    	return scrollToElement(text);
    }
    
    public ExpandableListsPage longPressPeopleNames() {
        performLongPress(peopleNamesItem, 2000);
        return this;
    }
    
    public boolean isSampleActionPopupDisplayed() {
        try {
            return waitForVisibility(sampleActionPopup).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
