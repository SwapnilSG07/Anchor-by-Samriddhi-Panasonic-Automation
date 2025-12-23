package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class ViewProfilePage extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	// ✅ Constructor-----------------------------------------------

	public ViewProfilePage(AndroidDriver driver) {
		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	// ✅ Page Objects using @AndroidFindBy---------------------------

	@AndroidFindBy(xpath = "")
	private WebElement myProfileBtn;

	@AndroidFindBy(xpath = "")
	private WebElement verifyProfileRedirectedPage;

	@AndroidFindBy(xpath = "")
	private WebElement verifyMobileNumber;

	@AndroidFindBy(xpath = "")
	private WebElement emailAddressBtn;

	@AndroidFindBy(xpath = "")
	private WebElement emailPagetitle;

	@AndroidFindBy(xpath = "")
	private WebElement currentEmailAddress;

	@AndroidFindBy(xpath = "")
	private WebElement newEmailAddress;

	@AndroidFindBy(xpath = "")
	private WebElement sendVerificationLink;

	@AndroidFindBy(xpath = "")
	private WebElement updateEmailBtn;

	@AndroidFindBy(xpath = "")
	private WebElement checkEmailStatus;

	// KYC--------------------------

	@AndroidFindBy(xpath = "")
	private WebElement checkKYCStausBeforeUdpate;

	@AndroidFindBy(xpath = "")
	private WebElement kycBtn;

	@AndroidFindBy(xpath = "")
	private WebElement kycPageTitle;

	@AndroidFindBy(xpath = "")
	private WebElement checkSelectionWeightage;

	@AndroidFindBy(xpath = "")
	private WebElement removeWeitagePopup;

	@AndroidFindBy(xpath = "")
	private WebElement KycProgressBar;

	// Shop Address

	@AndroidFindBy(xpath = "")
	private WebElement ShopAddBtn;

	@AndroidFindBy(xpath = "")
	private WebElement shopNameField;

	@AndroidFindBy(xpath = "")
	private WebElement Address1;

	@AndroidFindBy(xpath = "")
	private WebElement Address2;

	@AndroidFindBy(xpath = "")
	private WebElement Address3;

	@AndroidFindBy(xpath = "")
	private WebElement pincode;

	@AndroidFindBy(xpath = "")
	private WebElement Taluk;

	@AndroidFindBy(xpath = "")
	private WebElement Dist;

	@AndroidFindBy(xpath = "")
	private WebElement City;

	@AndroidFindBy(xpath = "")
	private WebElement State;

	@AndroidFindBy(xpath = "")
	private WebElement selectShopDoc;

	@AndroidFindBy(xpath = "")
	private WebElement selectedDocId;

	@AndroidFindBy(xpath = "")
	private WebElement takeDocPhotoCamera;

	@AndroidFindBy(xpath = "")
	private WebElement uploadDocPhoto;

	@AndroidFindBy(xpath = "")
	private WebElement ShopAddsubmitBtn;

	// Shop Outside Photo

	@AndroidFindBy(xpath = "")
	private WebElement shopOutsidePhoto;

	@AndroidFindBy(xpath = "")
	private WebElement clickSamplePhoto;

	@AndroidFindBy(xpath = "")
	private WebElement verifyLongShotShop;

	@AndroidFindBy(xpath = "")
	private WebElement verifyClosePhoto;

	@AndroidFindBy(xpath = "")
	private WebElement removePopClick;

	@AndroidFindBy(xpath = "")
	private WebElement takeLongShotfromCamera;

	@AndroidFindBy(xpath = "")
	private WebElement uploadLongShotGallery;

	@AndroidFindBy(xpath = "")
	private WebElement closePhotoCamera;

	@AndroidFindBy(xpath = "")
	private WebElement uploadClosePhoto;

	@AndroidFindBy(xpath = "")
	private WebElement shopOutsideSubmitBtn;

	// Shop Inside Photo

	@AndroidFindBy(xpath = "")
	private WebElement shopInsidePhoto;

	@AndroidFindBy(xpath = "")
	private WebElement checkSamplePhoto;

	@AndroidFindBy(xpath = "")
	private WebElement verifySamplePhotosTitle;

	@AndroidFindBy(xpath = "")
	private WebElement checkLongShotoPhoto;

	@AndroidFindBy(xpath = "")
	private WebElement checkCloseUpPhoto;

	@AndroidFindBy(xpath = "")
	private WebElement removeShopInsideSamplePhotoPopUp;

	@AndroidFindBy(xpath = "")
	private WebElement takeInsidePhotofromCamera;

	@AndroidFindBy(xpath = "")
	private WebElement uploadInsidePhotofromCamera;

	@AndroidFindBy(xpath = "")
	private WebElement takeClosePhotofromCamera;

	@AndroidFindBy(xpath = "")
	private WebElement takeUploadPhotofromCamera;

	@AndroidFindBy(xpath = "")
	private WebElement insidePhotoSubmitBtn;

	// Permanent Address

	@AndroidFindBy(xpath = "")
	private WebElement name;

	@AndroidFindBy(xpath = "")
	private WebElement mobileNumber;

	@AndroidFindBy(xpath = "")
	private WebElement permanentAddress1;

	@AndroidFindBy(xpath = "")
	private WebElement permanentAddress2;

	@AndroidFindBy(xpath = "")
	private WebElement permanentAddress3;

	@AndroidFindBy(xpath = "")
	private WebElement permanentPinCode;

	@AndroidFindBy(xpath = "")
	private WebElement permanentTaluk;

	@AndroidFindBy(xpath = "")
	private WebElement permanentDist;

	@AndroidFindBy(xpath = "")
	private WebElement permanentCity;

	@AndroidFindBy(xpath = "")
	private WebElement permanentState;

	@AndroidFindBy(xpath = "")
	private WebElement clickDropdownToSelectDoc;

	@AndroidFindBy(xpath = "")
	private WebElement permanentChooseDoc;

	@AndroidFindBy(xpath = "")
	private WebElement enterDocId;

	@AndroidFindBy(xpath = "")
	private WebElement clickDateOfBirth;

	@AndroidFindBy(xpath = "")
	private WebElement selectYear;

	@AndroidFindBy(xpath = "")
	private WebElement clickCalCancelBtn;

	@AndroidFindBy(xpath = "")
	private WebElement clickLeftTOSelectMonth;

	@AndroidFindBy(xpath = "")
	private WebElement clickOnDate;

	@AndroidFindBy(xpath = "")
	private WebElement uploadDocFrontPhoto;

	@AndroidFindBy(xpath = "")
	private WebElement uploadDocBackPhoto;

	@AndroidFindBy(xpath = "")
	private WebElement PersubmitBtn;

	@AndroidFindBy(xpath = "")
	private WebElement ClickCalOkBtn;

	// Current Address

	@AndroidFindBy(xpath = "")
	private WebElement clickCurrentBtn;

	@AndroidFindBy(xpath = "")
	private WebElement checkBox;

	@AndroidFindBy(xpath = "")
	private WebElement currAddress1;

	@AndroidFindBy(xpath = "")
	private WebElement currAddress2;

	@AndroidFindBy(xpath = "")

	@AndroidFindBy(xpath = "")
	private WebElement currAddress3;

	@AndroidFindBy(xpath = "")
	private WebElement currPinCode;

	@AndroidFindBy(xpath = "")
	private WebElement currTaluk;

	@AndroidFindBy(xpath = "")
	private WebElement currDist;

	@AndroidFindBy(xpath = "")
	private WebElement currCity;

	@AndroidFindBy(xpath = "")
	private WebElement currState;

	@AndroidFindBy(xpath = "")
	private WebElement currAddressDocDropdown;

	@AndroidFindBy(xpath = "")
	private WebElement chooseOptions;

	@AndroidFindBy(xpath = "")
	private WebElement CurrMoreOptionsDropdown;

	@AndroidFindBy(xpath = "")
	private WebElement enterIdNumber;

	@AndroidFindBy(xpath = "")
	private WebElement uploadCurrDocFrontPhoto;

	@AndroidFindBy(xpath = "")
	private WebElement uploadCurrDocBackPhoto;

	@AndroidFindBy(xpath = "")
	private WebElement clickOnSubmitBtn;

	// Delete Account ----------------

	@AndroidFindBy(xpath = "")
	private WebElement deleteAccountBtn;

	@AndroidFindBy(xpath = "")
	private WebElement VerifyPopText;

	@AndroidFindBy(xpath = "")
	private WebElement clickCancelBtn;

	@AndroidFindBy(xpath = "")
	private WebElement clickcontinueBtn;

	@AndroidFindBy(xpath = "")
	private WebElement enterReason;

	@AndroidFindBy(xpath = "")
	private WebElement submitBtn;

	@AndroidFindBy(xpath = "")
	private WebElement submissionText;

}
