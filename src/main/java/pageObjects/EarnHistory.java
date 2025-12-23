package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class EarnHistory extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	public EarnHistory() {

		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	// Page Objects---------------------------------------

	@AndroidFindBy(xpath = "")
	private WebElement menuBtn;

	@AndroidFindBy(xpath = "")
	private WebElement earnHistoryBtn;

	@AndroidFindBy(xpath = "")
	private WebElement verifyearnHistoryPage;

	@AndroidFindBy(xpath = "")
	private WebElement fromDate;

	@AndroidFindBy(xpath = "")
	private WebElement calCancelBtn;

	@AndroidFindBy(xpath = "")
	private WebElement calOkBtn;

	@AndroidFindBy(xpath = "")
	private WebElement toDate;

	@AndroidFindBy(xpath = "")
	private WebElement totalEarnedPoints;

	@AndroidFindBy(xpath = "")
	private List<WebElement> scannedCoupontotal;

	@AndroidFindBy(xpath = "")
	private WebElement searchcouponOption;

	@AndroidFindBy(xpath = "")
	private WebElement sortBtn;

	@AndroidFindBy(xpath = "")
	private WebElement verifySortBy;

	@AndroidFindBy(xpath = "")
	private WebElement selectOption;

	@AndroidFindBy(xpath = "")
	private WebElement SortOkBtn;

	// Methods--------------------------------------------

}