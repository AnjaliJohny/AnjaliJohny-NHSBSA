package com.qa.util;

import java.util.function.Function;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait implements org.openqa.selenium.support.ui.Wait<WebDriver>{
	private static final int WAIT_TIMEOUT=300;
	
	
public void waitForElementToDisplay(WebDriver driver,final WebElement element) {
	
try {
	new WebDriverWait(driver, WAIT_TIMEOUT).until(new ExpectedCondition<Boolean>() {

		@Override
		public Boolean apply(WebDriver driver) {
			//System.out.println(element+"Element  is displayed");
			return element.isDisplayed();
		}
	
});
	}
catch(TimeoutException e)	{
	e.printStackTrace();
}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public <T> T until(Function<? super WebDriver, T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}