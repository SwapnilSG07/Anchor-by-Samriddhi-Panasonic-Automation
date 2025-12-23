package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class Dashboard extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	public Dashboard() {

		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// Page Objects-------------------------------------------------

	@AndroidFindBy(xpath = "")
	private WebElement totalPoints;

	@AndroidFindBy(xpath = "")
	private WebElement verifyTotalPointsPage;

	@AndroidFindBy(xpath = "")
	private WebElement balancePoints;

	@AndroidFindBy(xpath = "")
	private WebElement verifyBalancePointsPage;

	@AndroidFindBy(xpath = "")
	private WebElement redeemedPoints;

	@AndroidFindBy(xpath = "")
	private WebElement verifyredemptionHistorypage;

	@AndroidFindBy(xpath = "")
	private WebElement yearTilldate;

	@AndroidFindBy(xpath = "")
	private WebElement verifyYTDPointsPage;

	@AndroidFindBy(xpath = "")
	private WebElement buPoints;

	@AndroidFindBy(xpath = "")
	private WebElement buDetailsScreenPage;

	// Clickon WD , WCT , SWG page objects

	@AndroidFindBy(xpath = "")
	private WebElement WD;

	@AndroidFindBy(xpath = "")
	private WebElement SWG;

	@AndroidFindBy(xpath = "")
	private WebElement WCT;

	// Methods--------------------------------------------------------

}