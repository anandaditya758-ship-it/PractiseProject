package com.infosys.automationqa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	public static void takeScreenshot(WebDriver driver) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg= new File("/reports/screenshots/");
	FileUtils.copyFile(src, trg);
}
}
