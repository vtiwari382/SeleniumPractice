package com.qa.saucedemo.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ProductPageTest extends BaseTest {
	
	
	@BeforeClass
	public void launchTheProductPage() {
		productPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("verifying the product page title")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1,groups={"Smoke"})
	public void verifyProductPageTitle() {
		String title = productPage.getProductsPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Description("verifying the product page header")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2,groups={"Sanity"})
	public void verifyProductPageHeader() {
		String header = productPage.getProductsPageHeadertext();
		Assert.assertEquals(header, "PRODUCTS");
	}
	
	@Description("Verifying all the products on page with the price")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3,groups={"Smoke","Sanity"})
	public void VerifyAllProductsOnPageWithPrice() {
		Map<String,String> productlist = productPage.getProductNameWithPriceTag();
		System.out.println("products list on page are : " + productlist);
		
		Assert.assertTrue(productlist.containsKey("Sauce Labs Bike Light"));
		Assert.assertTrue(productlist.containsKey("Test.allTheThings() T-Shirt (Red)"));
		Assert.assertTrue(productlist.containsKey("Sauce Labs Backpack"));
		Assert.assertTrue(productlist.containsKey("Sauce Labs Bolt T-Shirt"));
		Assert.assertTrue(productlist.containsKey("Sauce Labs Fleece Jacket"));
		Assert.assertTrue(productlist.containsKey("Sauce Labs Onesie"));
		
		Assert.assertEquals(productlist.get("Sauce Labs Bike Light"),"$9.99");
		Assert.assertEquals(productlist.get("Test.allTheThings() T-Shirt (Red)"),"$15.99");
		Assert.assertEquals(productlist.get("Sauce Labs Backpack"),"$29.99");
		Assert.assertEquals(productlist.get("Sauce Labs Bolt T-Shirt"),"$15.99");
		Assert.assertEquals(productlist.get("Sauce Labs Fleece Jacket"),"$49.99");
		Assert.assertEquals(productlist.get("Sauce Labs Onesie"),"$7.99");
	}
	
	@Description("Verifying the product in the cart")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4,dependsOnMethods="VerifyAllProductsOnPageWithPrice",groups={"Smoke","Sanity"})
	public void verifyTheProductinTheKart() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		String carttext = productPage.getAddToCarttext();
		Assert.assertEquals(carttext, "1");
	}

}
