package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AppiumUtils;

public class FAQs extends AppiumUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;
	private AppiumUtils utils;

	public FAQs() {

		this.driver = driver;
		this.utils = new AppiumUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	//Page objects-----------------------------------------
	
	@AndroidFindBy(xpath="")
	private WebElement menuBtn;
	
	@AndroidFindBy(xpath="")
	private WebElement faqBtn;
	
	@AndroidFindBy(xpath="")
	private WebElement faqText;

	@AndroidFindBy(xpath="")
	private WebElement questionsText;
	
	//Methods--------------------------------------------------
	
	
}

