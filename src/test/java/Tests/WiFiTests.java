package Tests;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import Helpers.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.android.HasNetworkConnection;
import io.appium.java_client.remote.MobileCapabilityType;

public class WiFiTests extends TestsBase {


	@Test
	public void CheckWiFiIsEnabledTest() {		
		
	    ((HasNetworkConnection) driver).setConnection(Connection.WIFI);
		
		assertEquals(Connection.WIFI,  ((HasNetworkConnection) driver).getConnection());
	}
}
