package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import Helpers.AppiumServer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestsBase {

	protected static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void StartServer() {
		
		try {
			AppiumServer.StartServer();
		}
		catch(Exception e) {
			e.printStackTrace();
		}			
	}

	@AfterClass
	public static void StopServer() {

		try {
			AppiumServer.StopServer();
		}
		catch(Exception e) {
			e.printStackTrace();
		}				
	}

	@Before
	public void SetUpDriver() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.APP, "");
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
		capabilities.setCapability("avd", "TestEmulator");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), capabilities);
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@After
	public void CloseDriver() {
		
		try {
			if (driver != null)
				driver.close();
				driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
			driver = null;
		}			
	}
}
