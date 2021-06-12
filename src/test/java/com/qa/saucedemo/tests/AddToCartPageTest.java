package com.qa.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.testlisteners.ExtentReportListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

//@Listeners(ExtentReportListener.class)   // to apply the listener at class level
public class AddToCartPageTest extends BaseTest {
	
	
	@BeforeClass
	public void AddToCartSetUp() {
		productPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("verifying the Title of Add To Cart Page")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1,groups={"Smoke"})
	public void verifyAddToCartPageTitle() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		addToCartPage=productPage.openTheCartpage();
		String title = addToCartPage.getAddToCartTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Description("Verify the quantity text")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2,groups={"Smoke"})
	public void verifyQuatityText() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		addToCartPage=productPage.openTheCartpage();
		String text=addToCartPage.getQuantityText();
		Assert.assertEquals(text, "QTY");
	}
	
	@Description("Verify the Description text")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3,groups={"Sanity"})
	public void verifyDescriptionText() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		addToCartPage=productPage.openTheCartpage();
		String description=addToCartPage.getDescriptionText();
		Assert.assertEquals(description, "DESCRIPTION");
	}
	
	@Description("Verify the name of Cart item")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4,groups={"Smoke","Sanity"})
	public void verifyCartItemName() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		addToCartPage=productPage.openTheCartpage();
		String cartitem=addToCartPage.getCartItemName();
		Assert.assertEquals(cartitem, "Sauce Labs Backpack");
	}
	
	@Description("Verify the Remove text")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=5,groups={"Smoke","Sanity"})
	public void verifyRemoveTextForProduct() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		addToCartPage=productPage.openTheCartpage();
		String removetext=addToCartPage.getRemoveTextForProduct();
		Assert.assertEquals(removetext, "REMOVE");
	}
	
	@Description("Verify the Checkout button")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=6,groups={"Smoke","Sanity"})
	public void verifyCheckoutButton() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		addToCartPage=productPage.openTheCartpage();
		String buttontext=addToCartPage.getCheckoutButton();
		Assert.assertEquals(buttontext, "CHECKOUT");
	}
	
	@Description("Verify the Continue Shopping Button")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority=7,groups={"Sanity"})
	public void verifyContinueShoppingButton() {
		productPage.addTheProductInTheKart("Sauce Labs Backpack");
		addToCartPage=productPage.openTheCartpage();
		String continueshoppingtext=addToCartPage.getContinueShoppingButton();
		Assert.assertEquals(continueshoppingtext, "CONTINUE SHOPPING");
	}

}
