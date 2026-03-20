package Hooks;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.DriverFactory;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.java.Scenario;
import Utility.ConfigReader;
import Utility.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static WebDriver driver;
	static ExtentReports extent = ExtentManager.getInstance();
	static ExtentTest test;

	@Before
	public void setup(Scenario scenario)

	{
		ConfigReader config = new ConfigReader();
		test = extent.createTest(scenario.getName());
		driver = DriverFactory.getDriver();	
		driver.get(config.getUrl());
	}

	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			test.fail("Test Failed");
		}else
		{
			test.pass("Test Passed");
		}
		extent.flush();
		driver.quit();
	}
}
