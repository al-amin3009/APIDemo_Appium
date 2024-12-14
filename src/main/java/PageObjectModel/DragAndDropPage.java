package PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import BasePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DragAndDropPage extends BasePage{

	public DragAndDropPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement sourceDot;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    private WebElement dragResultText;
    private int endX= 621;
    private int endY= 627;
    
    public void performDragAndDrop() {
        try {
        	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
    			    "elementId", ((RemoteWebElement) sourceDot).getId(),
    			    "endX", endX,
    			    "endY", endY
    			));
        } catch (Exception e) {
            throw new RuntimeException("Drag and drop operation failed", e);
        }
    }
    
    public String getDragResultText() {
        return waitForVisibility(dragResultText).getText();
    }

}
