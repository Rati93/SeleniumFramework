package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.DriverFactory;
import Pages.Cart;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;
import Hooks.Hooks;

public class ProductSteps {
	WebDriver driver = Hooks.driver;
	LoginPage login = new LoginPage(driver);
	HomePage home = new HomePage(driver);
	Cart cart = new Cart(driver);
	
	
	private static final Logger log = LogManager.getLogger(ProductSteps.class);
	ConfigReader config = new ConfigReader();

	@Given("User launches the browser")
	public void user_launches_the_browser()
	{
		log.info("Browser is launched");
	}
	
	@When("User navigates to the application")
	public void user_navigates_to_the_application()
	{
		log.info("User is navigated to application");
		login.navigateToSignInPage();
		
	}
	
	@And("User logs in with valid credentials")
	public void user_logs_in_with_valid_credentials()
	{
		log.info("User reachd to Login Page");
		login.loginUsername(config.getUsername());
		login.loginPassword(config.getPassword());
	}
	
	@And("User searches for {string}")
	public void user_searches_for(String product)
	{
		log.info("Here user will search for product");
		home.searchProduct(product);
		home.searchButton();
		log.info("Product is searched");
	}
	
	@And("User adds the product to cart")
	public void user_adds_the_product_to_cart()
	{
		log.info("Product is selected by User");
		cart.addToCart();
		log.info("Product is added to cart");
		String product = cart.Product();
		String productFromCartPage = cart.cartIcon();
		System.out.println(product);
		System.out.println(productFromCartPage);
		Assert.assertTrue(product.contains(productFromCartPage));
	}
	
	@Then("product should be visible in cart")
	public void product_should_be_visible_in_cart()
	{
		log.info("Product is visible");
	}
}
