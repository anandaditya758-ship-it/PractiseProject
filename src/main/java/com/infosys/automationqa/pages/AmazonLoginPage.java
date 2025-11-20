package com.infosys.automationqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.automationqa.base.BaseTest;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class AmazonLoginPage extends BaseTest{
	By emailid= By.xpath("//input[@name='email']");
	By contnue= By.xpath("//input[@type='submit']");
	By password= By.xpath("//input[@type='password']");
	By submit= By.xpath("//input[@type='submit']");
	By welcomemsg= By.xpath("//span[text()='Hello, Aditya']");
	
	String act;
	
	 public AmazonLoginPage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	
public void loginPage(String u)
{
 driver.findElement(emailid).sendKeys(u);
}

public void contnue()
{
	driver.findElement(contnue).click();
}
public void enterPassword(String p)
{
	driver.findElement(password).sendKeys(p);
}

public void submit()
{
	driver.findElement(submit).click();
}
public String welcomemsg()
{
	act=driver.findElement(welcomemsg).getText();
	return act;
}
}
