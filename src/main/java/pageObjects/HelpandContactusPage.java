package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class HelpandContactusPage extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	public HelpandContactusPage() {

		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// Page Objects-------------------------------------------

	@AndroidFindBy(xpath = "")
	private WebElement menuBtn;

	@AndroidFindBy(xpath = "")
	private WebElement helpAndContactBtn;

	@AndroidFindBy(xpath = "")
	private WebElement helpAndContactTitle;

	@AndroidFindBy(xpath = "")
	private WebElement clickOnMobileNumber;

	@AndroidFindBy(xpath = "")
	private WebElement verifyDialPad;

	@AndroidFindBy(xpath = "")
	private WebElement clickOnEmail;

	@AndroidFindBy(xpath = "")
	private WebElement verifyEmailRedirection;

	@AndroidFindBy(xpath = "")
	private WebElement complaintsBtn;

	@AndroidFindBy(xpath = "")
	private WebElement customerSupportPageTitle;

	@AndroidFindBy(xpath = "")
	private WebElement selectCategory;

	@AndroidFindBy(xpath = "")
	private WebElement seletSubCategory;

	@AndroidFindBy(xpath = "")
	private WebElement remarksAdd;

	@AndroidFindBy(xpath = "")
	private WebElement clickSubmitBtn;

	@AndroidFindBy(xpath = "")
	private WebElement getTheTicketNumber;

	@AndroidFindBy(xpath = "")
	private WebElement availableTickets;

	// Error------------------------------------------------

	@AndroidFindBy(xpath = "")
	private WebElement checkErrorMsg;

	@AndroidFindBy(xpath = "")
	private WebElement remarksError;

	// Methods-------------------------------------------------

}