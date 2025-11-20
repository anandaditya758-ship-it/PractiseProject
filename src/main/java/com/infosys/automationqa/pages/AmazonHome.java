package com.infosys.automationqa.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonHome {
	WebDriver driver;
	By searchbox= By.xpath("//input[@placeholder='Search Amazon.in']");
	By item=By.xpath("//*[@id=\"sac-suggestion-row-3-cell-1\"]/div[1]");
	By oppo=By.xpath("//*[@id=\"52cd045d-dd3f-4930-81fc-a5255a65b359\"]/div/div/span/div/div/div/div[2]/div/div/div[1]/a/h2/span/text()");
	By link=By.xpath("//div[text()='Get to Know Us']/following-sibling::ul");
	
public AmazonHome(WebDriver driver)
{
	this.driver=driver;
}
	public void enterSearchItem(String s)
	{
		driver.navigate().refresh();
		driver.findElement(searchbox).sendKeys(s);
		System.out.println("Search completed");
	}
	
	public void hoverAndSelect3rditem()
	{
		 WebElement ele = driver.findElement(item);
		 Actions actions = new Actions(driver);
		 actions.moveToElement(ele).click().perform(); // hover and select mobile under 10000 5g 6gb ram
		 System.out.println("hover successfull");
	}
	
	public void scrollAndSelect()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll down by 500 pixels
	    js.executeScript("window.scrollBy(0,500)");
	    // Store the current window handle
	    String parentWindow = driver.getWindowHandle();

	    // Click on the phone element
	    driver.findElement(oppo).click();

	    // Switch to the new window
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);  // new window me switch
	            break;
	        }
	    }

	    System.out.println("New window ka title: " + driver.getTitle());
	    System.out.println("scroll is successfull");
	}
	
	public void getAllfooterLinks() throws InterruptedException
	{
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		act.sendKeys(Keys.END).build().perform();
		Thread.sleep(5000);
		List<WebElement> links =driver.findElements(link);
		for(WebElement l : links )
		{
			 System.out.println(l.getText() + " --> " + l.getAttribute("href"));
		}
	}

}
