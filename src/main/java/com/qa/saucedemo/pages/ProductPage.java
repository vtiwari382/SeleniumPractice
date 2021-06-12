package com.qa.saucedemo.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.utils.ElementUtil;

import io.qameta.allure.Step;

public class ProductPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By productfilter = By.cssSelector(".product_sort_container");
	private By productsheader = By.cssSelector(".title");
	private By allproductonpage = By.xpath("//div[@class='inventory_list']/div/div[2]/div/a/div");
	private By allprodcutprice = By.cssSelector(".inventory_item_price");
	private By addtocart = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
	private By cartitemcount = By.xpath("//span[@class='shopping_cart_badge'][text()='1']");
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	@Step("getting the product page title ....")
	public String getProductsPageTitle() {
		return elementUtil.waitForTitlePresent("Swag Labs", 10);
	}
	
	@Step("Getting the text of Product Page header")
	public String getProductsPageHeadertext() {
		return elementUtil.doGetText(productsheader);
	}
	
	@Step("getting the product page filter")
	public void getProductFilters() {
		elementUtil.getDropDownValueWithoutSelectClass(productfilter);
	}
	
	@Step("Fetching all the products name on Product Page")
	public void getAllProductsNameOfPage() {
		elementUtil.getelementstext(allproductonpage);
		
	}
	
	@Step("getting text of add to cart")
	public String getAddToCarttext() {
//		elementUtil.waitForElementToBeLocated(cartitemcount, 10);
		if(elementUtil.doIsDisplayed(cartitemcount)) {
			return elementUtil.doGetText(cartitemcount);
		}
		return null;
		
	}
	
	@Step("getting products name with the price")
	public HashMap<String, String> getProductNameWithPriceTag() {
		HashMap<String, String> productinformation = new HashMap<>();
		List<String> product = new ArrayList<>();
		List<WebElement> allproducts = elementUtil.getElements(allproductonpage);
		
		for(WebElement e : allproducts) {
			product.add(e.getText().trim());
//			productinformation.put("ProductName", e.getText().trim());
			System.out.println("Products names are: " + product);
		}
		
		List<WebElement> productsprice = elementUtil.getElements(allprodcutprice);
		List<String> price = new ArrayList<>();
		for(WebElement f : productsprice) {
			price.add(f.getText().trim());
//			productinformation.put("ProductPrice", f.getText());
			System.out.println("Products names are: " + price);
		}
		if(product.size()==price.size()) {
			for (int i=0; i<product.size(); i++) {
				productinformation.put(product.get(i), price.get(i));
		    }
			
		}
		
		return productinformation;

	}
	
	@Step("Selecting the product: {0} and adding them in cart")
	public void addTheProductInTheKart(String productName) {
		List<WebElement>allproduct = elementUtil.getElements(allproductonpage);
		for(WebElement e: allproduct) {
			if(e.getText().equals(productName)) {
				elementUtil.getElement(addtocart).click();
			}
		}
	}
	
	@Step("Returning the Cart Page")
	public AddToCartPage openTheCartpage() {
		elementUtil.doClick(cartitemcount);
		return new AddToCartPage(driver);
	}
	
	
	

}
