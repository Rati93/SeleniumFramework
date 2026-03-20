package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	private static final Logger log = LogManager.getLogger(HomePage.class);
	
	@FindBy (id = "twotabsearchtextbox")
	WebElement searchField;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String product)
	{
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Enter Product name in Search Field");
		searchField.sendKeys(product);
		log.info("Product details are entered");
	}
	
	public void searchButton()
	{
		log.info("Click on Search Button");
		searchButton.click();
	}
	
}
