package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class CartPage extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	public CartPage() {

		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// PageObjects-------------------------------------------------

	@AndroidFindBy(xpath = "")
	private WebElement cartBtn;

	@AndroidFindBy(xpath = "")
	private WebElement cartPageVerification;

	@AndroidFindBy(xpath = "")
	private WebElement ClickOnBackButton;

	@AndroidFindBy(xpath = "")
	private WebElement verifytitle;

	@AndroidFindBy(xpath = "")
	private WebElement addressConfirmation;

	@AndroidFindBy(xpath = "")
	private WebElement selectAddress;

	@AndroidFindBy(xpath = "")
	private WebElement closeBtn;

	@AndroidFindBy(xpath = "")
	private WebElement verifynewlyAddedAddressReflection;

	@AndroidFindBy(xpath = "")
	private WebElement redirectionToTheCart;

	@AndroidFindBy(xpath = "")
	private WebElement verifyCartRedirection;

	// Methods---------------------------------------------------------------------

}