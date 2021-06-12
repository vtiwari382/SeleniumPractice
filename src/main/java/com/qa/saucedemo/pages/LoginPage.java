package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By username = By.cssSelector("#user-name");
	private By password = By.cssSelector("#password");
	private By loginbutton = By.cssSelector("#login-button");
	private By loginerrormsg = By.xpath("//h3[text()='Epic sadface: Username is required']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
		
	}
	@Step("getting the login page title .....")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitlePresent("Swag Labs", 10);
	}
	
	@Step("getting the error of login page ....")
	public String isLoginErrorPresent() {
		elementUtil.doClick(loginbutton);
		return elementUtil.doGetText(loginerrormsg);
	}
	
	@Step("login with the username: {0} and password: {1}")
	public ProductPage doLogin(String un, String pass) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pass);
		elementUtil.doClick(loginbutton);
		return new ProductPage(driver);
	}
	
	

}
