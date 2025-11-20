package com.infosys.automationqa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.infosys.automationqa.base.BaseTest;
import com.infosys.automationqa.pages.AmazonLoginPage;

public class AmazonLoginTest extends BaseTest{
	
	@Test(priority=1)
	public void successfulLogin() throws InterruptedException
	{
		AmazonLoginPage amz= new AmazonLoginPage(driver);
		amz.loginPage("a.anand1058@gmail.com");
		amz.contnue();
		amz.enterPassword("Krishna#1402");
		amz.submit();
		amz.welcomemsg();
		Thread.sleep(5000);
		String exp= "Hello, Aditya";
//		Assert.assertEquals(act, exp);
		String abc=amz.welcomemsg();
		System.out.println(abc);
		Assert.assertEquals(abc, exp);
		System.out.println("Login passed");
	}

}
