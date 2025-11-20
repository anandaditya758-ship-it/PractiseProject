package com.infosys.automationqa.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.infosys.automationqa.base.BaseTest;
import com.infosys.automationqa.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void successfulLogin()
	{
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername("a.anand1058@gmail.com");
		loginPage.requestotp();
		loginPage.enterOTP();
		
	}
}
