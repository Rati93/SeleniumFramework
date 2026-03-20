package Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	
	@FindBy(xpath = "//*[@id= 'nav-link-accountList-nav-line-1']")
    WebElement Account;
	
	@FindBy(id="ap_email_login")
	WebElement Username;

	@FindBy(xpath="//*[@class='a-button-input']")
	WebElement Continue;

	@FindBy(id = "ap_password")
	WebElement Password;

	@FindBy(id = "signInSubmit")
	WebElement SignIn;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToSignInPage()
	{
		log.info("Navigating to Sign in Page");
		Account.click();
		log.info("Enter Sign In Details");
	}
	public void loginUsername(String username)
	{
		log.info("Enter Username and Password");
		Username.sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(Continue));
		Continue.click();
	}
	
	public void loginPassword(String password)
	{
		log.info("Enter Password");
		wait.until(ExpectedConditions.visibilityOf(Password));
		Password.sendKeys(password);
		SignIn.click();
		log.info("Username and Password entered");
	}

}
