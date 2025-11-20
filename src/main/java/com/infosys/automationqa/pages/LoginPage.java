package com.infosys.automationqa.pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  WebDriver driver;
  
//  By username= By.xpath("//input[@name='username']");
//  By password= By.xpath("//input[@name='password']");
//  By loginbtn=By.xpath("//input[@value='Log In']");
    By username= By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input");
    By reqotp=By.xpath("//button[text()='Request OTP']");
    By otpfield= By.xpath("//*[@id=\'container\']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input");

 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
 }
 
 public void enterUsername(String u) {
	 driver.findElement(username).sendKeys(u);
 }
 
 public void requestotp()
 {
	 driver.findElement(reqotp).click();
 }
 public void enterOTP()
 {
	 System.out.print("Enter OTP from phone: ");
	    Scanner sc = new Scanner(System.in);
	    String otp = sc.nextLine();
	    driver.findElement(otpfield).sendKeys(otp);
	   
 }
  
}

