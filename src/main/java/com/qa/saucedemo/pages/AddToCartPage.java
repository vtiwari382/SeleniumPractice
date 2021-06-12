package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.utils.ElementUtil;

public class AddToCartPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	

	private By quantitytext = By.cssSelector(".cart_quantity_label");
	private By descriptiontxt = By.cssSelector(".cart_desc_label");
	private By cartitemname = By.cssSelector(".inventory_item_name");
	private By removetxtonproduct = By.cssSelector("#remove-sauce-labs-backpack");
	private By checkoutbutton = By.id("checkout");
	private By continueshoppingbtn = By.id("continue-shopping");
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	
	public String getAddToCartTitle() {
		return elementUtil.waitForTitlePresent("Swag Labs",10);
	}
	
	public String getQuantityText() {
		return elementUtil.doGetText(quantitytext);
	}
	
	public String getDescriptionText() {
		return elementUtil.doGetText(descriptiontxt);
	}
	
	public String getCartItemName() {
		return elementUtil.doGetText(cartitemname);
	}
	
	public String getRemoveTextForProduct() {
		return elementUtil.doGetText(removetxtonproduct);
	}
	
	public String getCheckoutButton() {
		return elementUtil.doGetText(checkoutbutton);
	}
	
	public String getContinueShoppingButton() {
		return elementUtil.doGetText(continueshoppingbtn);
	}

}
