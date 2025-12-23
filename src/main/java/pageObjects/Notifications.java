package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class Notifications extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	// ✅ Constructor
	public Notifications(AndroidDriver driver) {
		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// PageObejcts----------------------------------

	@AndroidFindBy(xpath = "")
	private WebElement notificationBtn;

	@AndroidFindBy(xpath = "")
	private WebElement notoficationPageRedirection;

	// Methods------------------------------------------------

	public void clickOnNotificationButton() {

	}

	public void verifyNotificationPageTitle() {

	}

}
