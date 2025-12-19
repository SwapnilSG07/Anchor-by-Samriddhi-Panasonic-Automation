
package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class LoginPage {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	// ✅ Constructor
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// ✅ Page Objects using @AndroidFindBy

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-input-outlined']")
	private WebElement mobileNumberField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='button-text' and @text='GET OTP']")
	private WebElement getOtpButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='GET OTP']/parent::*")
	private WebElement getOtpButtonDis;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='card-container']//android.widget.EditText")
	private List<WebElement> putOtp;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'Submit')]")
	private WebElement submitBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Member not found']")
	private WebElement memberNotFound;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='OK']/android.view.ViewGroup")
	private WebElement okPopBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private WebElement continueBtn;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout//android.widget.Button")
	private List<WebElement> permissionOptionsCamera;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow Media Access']")
	private WebElement mediaText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='button-text']")
	private WebElement mediaContinueBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Provide Location Permissions']")
	private WebElement LocText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='button-text']")
	private WebElement locBtn;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout//android.widget.Button")
	private List<WebElement> permissionLocButtons;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hi, Test Retailer']")
	private WebElement hiTestRetailer;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_1__']/android.view.ViewGroup[2]")
	private WebElement okLetsGoBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='󰅖']")
	private WebElement removePop;

	// ✅ Methods
	public void enterMobileNumber(String mobileNumber) {
		wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
		mobileNumberField.sendKeys(mobileNumber);
		System.out.println("Entered mobile number: " + mobileNumber);
	}

	public boolean isGetOtpButtonDisabled() {
		String state = getOtpButtonDis.getAttribute("enabled");
		return state.equals("false");
	}

	public void clickGetOtpButton() {
		wait.until(ExpectedConditions.elementToBeClickable(getOtpButton));
		getOtpButton.click();
		System.out.println("Clicked Get OTP button.");
	}

	public void enterOtp(String otp) {
		if (otp.length() != 6) {
			throw new IllegalArgumentException("OTP must be exactly 6 digits");
		}
		wait.until(ExpectedConditions.visibilityOfAllElements(putOtp));
		for (int i = 0; i < putOtp.size(); i++) {
			putOtp.get(i).clear();
			putOtp.get(i).sendKeys(String.valueOf(otp.charAt(i)));
		}
		System.out.println("Entered OTP: " + otp);
	}

	public boolean isSubmitButtonDisabled() {
		return !submitBtn.isEnabled();
	}

	public boolean isSubmitButtonEnabled() {
		return submitBtn.isEnabled();
	}

	public void waitForSubmitButtonToEnable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(driver -> submitBtn.isEnabled());
	}

	public void clickSubmitButton() {
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
	}

	public boolean isMemberNotFoundAlertDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(memberNotFound));
			return memberNotFound.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickMemberNotFoundOk() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(okPopBtn));
		okPopBtn.click();
	}

	public void clickContinueButton() {
		utils.waitForClick(continueBtn);
		continueBtn.click();
		System.out.println("Clicked Continue button");
	}

	public void clickOptionByIndex(int index) {
		if (permissionOptionsCamera == null || permissionOptionsCamera.isEmpty()) {
			throw new RuntimeException("No permission options found!");
		}

		if (index >= 0 && index < permissionOptionsCamera.size()) {
			String optionText = permissionOptionsCamera.get(index).getText();
			System.out.println("Clicking option at index " + index + ": " + optionText);
			permissionOptionsCamera.get(index).click();
			System.out.println("Element selected as per the index");
		} else {
			throw new IllegalArgumentException(
					"Invalid index: " + index + ". Available options: " + permissionOptionsCamera.size());
		}
	}

	public void verifyMediaAccessText() {
		wait.until(ExpectedConditions.visibilityOf(mediaText));
		Assert.assertTrue(mediaText.isDisplayed(), "'Allow Media Access' text is NOT displayed on the page");
		Assert.assertEquals(mediaText.getText(), "Allow Media Access", "Text does not match expected value");
		System.out.println("Verified: 'Allow Media Access' text is present and correct.");
	}

	public void MediaAccessContinueButton() {
		try {
			utils.waitForClick(mediaContinueBtn);
			Assert.assertTrue(mediaContinueBtn.isDisplayed(), "Media Access Continue button should be displayed");
			mediaContinueBtn.click();
			System.out.println("Clicked Media access Continue button");
		} catch (Exception e) {
			throw new AssertionError("Media Access Continue button not found or not clickable within timeout.");
		}
	}

	public void verifyLocationText() {
		wait.until(ExpectedConditions.visibilityOf(LocText));
		Assert.assertTrue(LocText.isDisplayed(), "'Provide Location Permissions' text is NOT displayed on the page");
		Assert.assertEquals(LocText.getText(), "Provide Location Permissions", "Text does not match expected value");
		System.out.println("Verified: 'Provide Location Permissions' text is present and correct.");
	}

	public void locationPermissionButton() {
		try {
			utils.waitForClick(locBtn);
			Assert.assertTrue(locBtn.isDisplayed(), "Provide Location Permissions button should be displayed");
			locBtn.click();
			System.out.println("Clicked Provide Location Permissions button");
		} catch (Exception e) {
			throw new AssertionError("Provide Location Permissions button not found or not clickable within timeout.");
		}
	}

	public String clickOptionByIndexLoc(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(permissionLocButtons));

		if (permissionLocButtons == null || permissionLocButtons.isEmpty()) {
			throw new RuntimeException("No permission options found!");
		}

		if (index >= 0 && index < permissionLocButtons.size()) {
			String optionText = permissionLocButtons.get(index).getText();
			System.out.println("Clicking option at index " + index + ": " + optionText);
			permissionLocButtons.get(index).click();
			return optionText;
		} else {
			throw new IllegalArgumentException(
					"Invalid index: " + index + ". Available options: " + permissionLocButtons.size());
		}
	}

	public void panasonicTestRetailerText() {
		utils.waitForElementToAppear(hiTestRetailer, "Hi, Test Retailer");
		String text = hiTestRetailer.getText();
		Assert.assertEquals(text, "Hi, Test Retailer");
		System.out.println("Verified text: " + text);
	}

	public void clickOkLetsGoIfDisplayed() {
		try {
			utils.waitForClick(okLetsGoBtn);
			Assert.assertTrue(okLetsGoBtn.isDisplayed(), "OKay lets go! button should be displayed");
			okLetsGoBtn.click();
			System.out.println("Clicked 'OKay lets go!' button.");
		} catch (Exception e) {
			throw new AssertionError("'OKay lets go!' button not found or not clickable within timeout.");
		}

	}

	public void removePromotionalPop() {
	    try {
	        if (removePop.isDisplayed()) {
	            removePop.click();
	            System.out.println("Popup removed successfully.");
	        }
	    } catch (Exception e) {
	        System.out.println("Popup not displayed, continuing execution.");
	    }
	}



}
