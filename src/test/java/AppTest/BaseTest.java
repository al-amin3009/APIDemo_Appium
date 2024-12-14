package AppTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	File appiumServerJsFile = new File("C:\\Users\\Al-Amin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
	String appiumIPAddress= "127.0.0.1";
	int Port = 4723;
	String DeviceName = "Pixel7";
	String AbsolutePathToApk= "D:\\Selenium Project\\APIDemo\\src\\test\\java\\resource\\ApiDemos-debug.apk";
	String AppiumServerURL = "http://127.0.0.1:4723";
	
	@BeforeClass
	public void LaunchApplication() throws MalformedURLException {
		//Configure and start appium server
		service = new AppiumServiceBuilder().withAppiumJS(appiumServerJsFile)
						.withIPAddress(appiumIPAddress)
						.usingPort(Port)
						.build();
		service.start();
		
		//configure desired capabilities for Android app automation
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(DeviceName);
		options.setApp(AbsolutePathToApk);
		// establishes a connection between your test script and the Appium server
		driver = new AndroidDriver(new URL(AppiumServerURL), options);
		
		// global implicit timeouts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// navigate back to the previous page n times
	public void navigateBack(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            
                driver.navigate().back();
                Thread.sleep(500);  // Small delay to allow UI to update
        }
    }
	
	@AfterClass
	public void tearDown() {
		//Quit the session
		driver.quit();
        service.stop();
	}
}
