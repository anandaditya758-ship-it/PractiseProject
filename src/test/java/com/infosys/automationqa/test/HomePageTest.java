package com.infosys.automationqa.test;

import org.testng.annotations.Test;

import com.infosys.automationqa.base.BaseTest;
import com.infosys.automationqa.pages.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void enterSearchItem() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		hp.enterSearchItem("Mobile under 10000 5g");
		hp.clickElement(); // it add the phone from search result
		hp.scrollAndSelectPhone();
	}
	
	
}
