package com.infosys.automationqa.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.infosys.automationqa.base.BaseTest;
import com.infosys.automationqa.pages.AmazonHome;
import com.infosys.automationqa.pages.AmazonLoginPage;

public class AmazonHomePageTest extends BaseTest{
	//WebDriver driver;

	@Test(enabled=false)
	public void Searchitem() throws InterruptedException
	{
	
		AmazonHome amz=new AmazonHome(driver);
		amz.enterSearchItem("Mobile under 10000 5g");
		amz.hoverAndSelect3rditem();
		amz.scrollAndSelect();
	}
	
	@Test(priority=2)
	public void getAllLinks() throws InterruptedException
	{
	
		AmazonHome amz=new AmazonHome(driver);
		amz.getAllfooterLinks();
		System.out.println("Triggered success");
	}
	
	
}
