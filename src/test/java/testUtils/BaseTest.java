package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import utils.AppiumUtils;

public class BaseTest extends AppiumUtils {

    public BaseTest(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public AndroidDriver driver; // Global driver for all methods
    public AppiumDriverLocalService service;

    @BeforeClass(alwaysRun = true)
    public void configureAppium() throws IOException {

        // Load configuration from properties file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/java/org/rahulshettyacademy/resources/data.properties");
        prop.load(fis);

        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");

        // Start Appium server
        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        // Set Android options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("AndroidDeviceNames"));

        // Use relative path for Chromedriver
        options.setChromedriverExecutable(
                System.getProperty("user.dir") + "/src/main/java/org/rahulshettyacademy/resources/chromedriver.exe");

        // Use relative path for APK
        options.setApp(System.getProperty("user.dir")
                + "/src/main/java/org/rahulshettyacademy/resources/General-Store.apk");

        // Initialize AndroidDriver
        driver = new AndroidDriver(service.getUrl(), options);

        // Global implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize page objects
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
