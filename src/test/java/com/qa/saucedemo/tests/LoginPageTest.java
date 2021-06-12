package com.qa.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {
	
	@Description("Verify the Login Page Title")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=1,groups={"Smoke"})
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("title of the login page is :" + title);
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Description("Verify the error on login page")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2,groups={"Sanity"})
	public void verifyLoginError() {
		String error = loginPage.isLoginErrorPresent();
		System.out.println("error msg of login page is :" + error);
		Assert.assertEquals(error, "Epic sadface: Username is required");
	}
	
	@Description("login into the application")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority=3,groups={"Smoke","Sanity"})
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
