package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class RedemptionHistory extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	// ✅ Constructor
	public RedemptionHistory(AndroidDriver driver) {
		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// PageObjects------------------------

	@AndroidFindBy(xpath = "")
	private WebElement menuBtn;

	@AndroidFindBy(xpath = "")
	private WebElement redemptionHistoryBtn;

	@AndroidFindBy(xpath = "")
	private WebElement redemptionPageText;

	@AndroidFindBy(xpath = "")
	private WebElement searchOrderId;
	
	@AndroidFindBy(xpath = "")
	private WebElement clickorderId;

	@AndroidFindBy(xpath = "")
	private WebElement verifyRedirectedPage;

	@AndroidFindBy(xpath = "")
	private WebElement verifyOrderId;

	@AndroidFindBy(xpath = "")
	private WebElement clickOnRedeemedProd;

	@AndroidFindBy(xpath = "")
	private WebElement verifyTrackingInformationPage;
	
	@AndroidFindBy(xpath="")
	private WebElement CheckProdStatus;

	// Methods------------------------------
	
	
}
