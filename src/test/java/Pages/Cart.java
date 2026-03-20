package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

	WebDriver driver;
	String product;
	String productName;
	
	@FindBy(xpath = "//*[@name='submit.addToCart']")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[@id='nav-cart-count']")
	WebElement cartIcon;
	
	@FindBy(xpath = "//*[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")
	WebElement Product;
	
	@FindBy(xpath = "//*[@class='a-truncate-full a-offscreen']")
	WebElement ProductNameFromCartPage;
	
	private static final Logger log = LogManager.getLogger(Cart.class);
	public Cart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart()
	{
		log.info("Click on Add To Cart");
		addToCart.click();
		log.info("Product added to Cart");
	}
	
	public String Product()
	{
		log.info("Get Product text");
		product = Product.getText();
		log.info("Product Name : ",product);
		return product;
	}
	
	public String cartIcon()
	{
		log.info("Go to Cart Page");
		cartIcon.click();
		log.info("Navigated to Cart page");
		productName = ProductNameFromCartPage.getText();
		return productName;
	} 
}
