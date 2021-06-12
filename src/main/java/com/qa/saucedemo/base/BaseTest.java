package com.qa.saucedemo.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.saucedemo.pages.AddToCartPage;
import com.qa.saucedemo.pages.LoginPage;
import com.qa.saucedemo.pages.ProductPage;

public class BaseTest {
	
	public BasePage basePage;
	public LoginPage loginPage;
	public ProductPage productPage;
	public AddToCartPage addToCartPage;
	
	public Properties prop;
	public WebDriver driver;

	@Parameters({"browser","version"})     // if we have parameters,then to use browser of config.properties file run testcases from test class not from testng.xml file 
	@BeforeTest
	public void setUp(String browserName, String browserVersion) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		if(browserName !=null) {
			browser = browserName;
		}
		driver = basePage.init_driver(browser,browserVersion);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
				
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}

/**
Hierarchy of the TestNG Annotations:
@BeforeSuite:The @BeforeSuite annotated method will run before the execution of all the test methods in the suite.
@BeforeTest:The @BeforeTest annotated method will be executed before the execution of all the test methods of available classes belonging to that folder
@BeforeClass:The @BeforeClass annotated method will be executed before the first method of the current class is invoked.
@BeforeMethod:The @BeforeMethod annotated method will be executed before each test method will run.
@Test: here we write our testcases.
@AfterMethod:The @AfterMethod annotated method will run after the execution of each test method.
@AfterClass:The @AfterClass annotated method will be invoked after the execution of all the test methods of the current class.
@AfterTest:The @AfterTest annotated method will be executed after the execution of all the test methods of available classes belonging to that folder.
@AfterSuite:The @AfterSuite annotated method will run after the execution of all the test methods in the suite.
 */
