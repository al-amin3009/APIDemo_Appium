package BasePage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {
	protected AndroidDriver driver;
    protected WebDriverWait wait;
    
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
    
   
    // Utility method to wait for element to be visible
    protected WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    // Scroll to an element
    protected WebElement scrollToElement(String text) {
        try {
            return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))"
            ));
        } catch (Exception e) {
            throw new RuntimeException("Could not scroll to element with text: " + text, e);
        }
    }
    
    // Perform a long press on an item
    protected void performLongPress(WebElement element, int duration) {
    	try {
    		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    			    "elementId", ((RemoteWebElement) element).getId(),
    			    "duration", duration
    			));
    	} catch (Exception e) {
            throw new RuntimeException("Failed to perform long press", e);
        }
    }

}
