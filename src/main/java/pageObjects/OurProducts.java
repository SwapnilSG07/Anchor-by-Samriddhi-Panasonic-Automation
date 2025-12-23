package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class OurProducts extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	// ✅ Constructor
	public OurProducts(AndroidDriver driver) {
		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// PageObjects----------------------------------------

	@AndroidFindBy(xpath = "")
	private WebElement menuBtn;

	@AndroidFindBy(xpath = "")
	private WebElement ourProductsBtn;

	@AndroidFindBy(xpath = "")
	private WebElement productsPage;

	@AndroidFindBy(xpath = "")
	private WebElement Banner;

	@AndroidFindBy(xpath = "")
	private WebElement clickOnProduct;

	@AndroidFindBy(xpath = "")
	private WebElement checkClickedProd;

	@AndroidFindBy(xpath = "")
	private WebElement clickOnLink;

	@AndroidFindBy(xpath = "")
	private WebElement verifyPage;

	@AndroidFindBy(xpath = "")
	private WebElement CancelBtn;

	@AndroidFindBy(xpath = "")
	private WebElement DownloadBtn;

	@AndroidFindBy(xpath = "")
	private WebElement verifydDownloadsPage;

	@AndroidFindBy(xpath = "")
	private WebElement OpenFile;

	@AndroidFindBy(xpath = "")
	private WebElement verifyOpenedFileProduct;

	@AndroidFindBy(xpath = "")
	private WebElement closeBtn;

	// Methods---------------------------------------------------

	
}
