
package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testUtils.BaseTest;

public class LoginPageTest extends BaseTest {

	public LoginPageTest() {
		super(); // No changes here
	}

	@Test()
	public void validateLoginProcess() throws InterruptedException {
		System.out.println("===== Starting Test: validateLoginProcess =====");

		LoginPage loginPage = new LoginPage(driver);
		// Login Process
		String mobileNumber = prop.getProperty("Username");
		System.out.println("[Step 1] Entering mobile number: " + mobileNumber);
		loginPage.enterMobileNumber(mobileNumber);

		System.out.println("[Step 2] Clicking Get OTP button...");
		loginPage.clickGetOtpButton();

		System.out.println("[Step 3] Verifying Submit button is disabled...");
		Assert.assertTrue(loginPage.isSubmitButtonDisabled(), "Submit button should be disabled initially");
		System.out.println("✔ Submit button is disabled initially.");

		String otp = prop.getProperty("OTP");
		System.out.println("[Step 4] Entering OTP: " + otp);
		loginPage.enterOtp(otp);

		System.out.println("[Step 5] Waiting for Submit button to enable...");
		loginPage.waitForSubmitButtonToEnable();
		Assert.assertTrue(loginPage.isSubmitButtonEnabled(),
				"Submit button should be enabled after entering valid OTP");
		System.out.println("✔ Submit button enabled successfully");

		System.out.println("[Step 6] Clicking Submit button...");
		loginPage.clickSubmitButton();
		// Access
		loginPage.clickContinueButton();
		Thread.sleep(2000);
		loginPage.clickOptionByIndex(0);
		Thread.sleep(7000);
		loginPage.verifyMediaAccessText();
		loginPage.MediaAccessContinueButton();
		Thread.sleep(2000);
		loginPage.verifyLocationText();
		loginPage.locationPermissionButton();
		Thread.sleep(2000);
		loginPage.clickOptionByIndexLoc(0);
		Thread.sleep(5000);
		// Dashboard
		loginPage.panasonicTestRetailerText();
		Thread.sleep(7000);
		loginPage.clickOkLetsGoIfDisplayed();
		Thread.sleep(5000);
		loginPage.removePromotionalPop();
		Thread.sleep(3000);

		System.out.println("===== Test Completed: validateLoginProcess =====");
	}

	@Test(enabled = false)
	public void validateInvalidMobileNumber_LengthCheck() {

		System.out.println("===== TEST: Invalid Mobile Length =====");

		LoginPage loginPage = new LoginPage(driver);

		// Enter less than 10 digits (invalid)
		String invalidMobile = "98765"; // "9 digits"
		loginPage.enterMobileNumber(invalidMobile);

		// Validate Get OTP button disabled
		Assert.assertTrue(loginPage.isGetOtpButtonDisabled(),
				"Get OTP must remain disabled for invalid mobile length!");

		System.out.println("✔ Get Oenabled=falseTP button correctly disabled for <10 digits mobile number");
	}

	@Test(enabled = false)
	public void validateInvalidMobileNumber_Unregistered() {

		System.out.println("===== TEST: Unregistered Mobile =====");

		LoginPage loginPage = new LoginPage(driver);

		String unregisteredMobile = "9604969435";
		loginPage.enterMobileNumber(unregisteredMobile);
		loginPage.clickGetOtpButton();

		// Validate alert "Member not found"
		Assert.assertTrue(loginPage.isMemberNotFoundAlertDisplayed(), "Expected popup alert 'Member not found'");

		System.out.println("✔ Proper error displayed for unregistered mobile number/Member Not Found");

		Assert.assertTrue(loginPage.isMemberNotFoundAlertDisplayed(),
				"Expected 'Member not found' alert to be displayed");
		System.out.println("✔ 'Member not found' alert displayed");

		loginPage.clickMemberNotFoundOk();
		System.out.println("✔ Alert popup closed successfully");

		System.out.println("===== Test Completed =====");
	}
}
