
package testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.AppiumUtils;

public class BaseTest extends AppiumUtils {

	protected Properties prop;

	// ✅ Default constructor for TestNG
	public BaseTest() {
		super(); // Calls AppiumUtils default constructor
	}

	@BeforeTest(alwaysRun = true)
	public void configureAppium() throws IOException {
		// Load configuration from properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);

		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		// Start Appium server using AppiumUtils method
		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		// Set Android options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceNames"));

		// Use relative path for Chromedriver
		options.setChromedriverExecutable(
				System.getProperty("user.dir") + "/src/main/java/org/rahulshettyacademy/resources/chromedriver.exe");

		// Use relative path for APK
		options.setApp(System.getProperty("user.dir") + "/src/test/java/appResources/Panasonic.apk");

		// Initialise AndroidDriver (driver is inherited from AppiumUtils)
		driver = new AndroidDriver(service.getUrl(), options);
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("autoGrantPermissions", true);

		// Global implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeEachTest() {
		System.out.println("**** Reset App Before Every Test ****");
		try {
			// ✅ Correct method for Appium Java Client v8+
			driver.terminateApp("com.plsindloyalty.anchor.samriddhi");
			driver.activateApp("com.plsindloyalty.anchor.samriddhi");
			System.out.println("App reset successfully.");
		} catch (Exception e) {
			System.out.println("App reset	 failed: " + e.getMessage());
		}
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		if (service != null) {
			service.stop();
		}
	}
}
