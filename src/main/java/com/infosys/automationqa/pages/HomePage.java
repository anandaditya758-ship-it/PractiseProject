package com.infosys.automationqa.pages;

import java.time.Duration;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	WebDriver driver;
	
	By searchbox = By.xpath("//input[@class='Pke_EE']");
	By element = By.xpath("//div[@class='YGcVZO _2VHNef']"); 
	By phone=By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[4]/div/div/div/a/div[2]/div[1]/div[1] ");
    By buynow=By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button"); 
    By emailid=By.xpath("//input[@class='r4vIwl Jr-g+f']");
    By continuee= By.xpath("//button[@type='submit']");
    By otpfield= By.xpath("//*[@id=\'container\']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input");
    By login=By.xpath("//button[@type='submit']");
    By deliverhere= By.xpath("//button[text()='Deliver Here']");
    By clickContinue=By.xpath("//button[text()='CONTINUE']");
    By accept = By.xpath("//button[text()='Accept & Continue']");
    By cod = By.xpath("//span[text()='Cash on Delivery']");
    By placeorder=By.xpath("//button[text()='Place Order']");
                        
	 public HomePage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void enterSearchItem(String s)
	 {
		 driver.findElement(searchbox).sendKeys(s);
	 }
	 
	 public void clickElement()
	 {
		 WebElement ele = driver.findElement(element);

		 Actions actions = new Actions(driver);
		 actions.moveToElement(ele).click().perform(); // hover and select mobile under 10000 5g 6gb ram
	 }
	 
	 public void scrollAndSelectPhone() throws InterruptedException {
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Scroll down by 500 pixels
		    js.executeScript("window.scrollBy(0,500)");

		    // Store the current window handle
		    String parentWindow = driver.getWindowHandle();

		    // Click on the phone element
		    driver.findElement(phone).click();

		    // Switch to the new window
		    Set<String> allWindows = driver.getWindowHandles();
		    for (String window : allWindows) {
		        if (!window.equals(parentWindow)) {
		            driver.switchTo().window(window);  // new window me switch
		            break;
		        }
		    }

		    System.out.println("New window ka title: " + driver.getTitle());

		    // Scroll to the Buy Now button
		    WebElement buyNowBtn = driver.findElement(buynow);
		    js.executeScript("arguments[0].scrollIntoView(true);", buyNowBtn);

		    // Click the Buy Now button
		    buyNowBtn.click();
		    
		    //enter email id
		    driver.findElement(emailid).sendKeys("a.anand1058@gmail.com");
		    
		    //click continue
		    driver.findElement(continuee).click();
		    Thread.sleep(3000);
		    
		    //enter otp from phone
		    System.out.print("Enter OTP from phone: ");
		    Scanner sc = new Scanner(System.in);
		    String otp = sc.nextLine();
		    driver.findElement(otpfield).sendKeys(otp);
		    driver.findElement(login).click();
		    Thread.sleep(3000);
		    
		    //click on deliver here
		    driver.findElement(deliverhere).click();
            
		    //click on continue
		    driver.findElement(clickContinue).click();
		    
		    //click on accept
		    driver.findElement(accept).click();
		    
		    //scroll to cash on delivery button
		    WebElement codbtn = driver.findElement(cod);
		    js.executeScript("arguments[0].scrollIntoView(true);", codbtn);
		    
		    //click on cod
		    codbtn.click();
		    Thread.sleep(3000);
		    
		    //click on place order
		    driver.findElement(placeorder).click();

		    System.out.println("Order Placed successfully");
		}
}
