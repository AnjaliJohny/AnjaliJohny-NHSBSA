package com.qa.util;


import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.Base;

public class GenericFunction extends Base{
	
	Wait wait=new Wait();
	public GenericFunction() {
		super();
	}
	
	//method to click
	public void ClickElement(WebElement element,String strButtonName) {
		try {
			wait.waitForElementToDisplay(driver, element);
			element.click();
		
		
			System.out.println(strButtonName+" is clicked");
			extentTest.log((Status.PASS),strButtonName+" is clicked");
		}
		catch(NoSuchElementException e) {
			System.out.println(strButtonName+" is not clicked");
			extentTest.log((Status.FAIL),strButtonName+" is not clicked");
		}
		catch(Exception e) {
			System.out.println(strButtonName+" is not clicked");
			extentTest.log((Status.FAIL),strButtonName+" is not clicked");
	}
}
	
   public void assertElementDisplaye(WebElement element,String elementName) {
	   try {
		   if(element.isDisplayed()) {
			   extentTest.log((Status.PASS),elementName+" is displayed");
			   System.out.println("element is displayed");
		   }
		   else {
			   extentTest.log((Status.FAIL),elementName+" is not displayed");
			   System.out.println("element not displayed");
		   }
	}catch(Exception e) {
		e.printStackTrace();
	}
   }
   
   //method to compare text
   public boolean assertText(WebElement element,String expectedText,String elementName) {
	   try {	
		   if(element.getText().equals(expectedText)) 
		   {
			   extentTest.log((Status.PASS),elementName+"'s Text is "+ expectedText);
		   System.out.println(elementName+ "'s Text is "+ expectedText);
		   return true;
		   }
		   else {
			   extentTest.log((Status.FAIL),elementName+"'s Text is not "+ expectedText);
			   System.out.println(elementName+"'s Text is different");
		   return false;
		   }
		   }
	   catch(NoSuchElementException e) {
		   e.printStackTrace();
			return false;
	   }

	   
   }
   //method to enter text
   public void EnterText(WebElement element,String strValue,String strdesc) {
	   try {
		   if(!strValue.isEmpty()) {
			   strValue=strValue.trim();
			   element.clear();
			   element.sendKeys(strValue);
			   extentTest.log((Status.PASS),strValue+" is entered in "+strdesc);
			   System.out.println(strValue+" is entered in "+strdesc);
		   }
		   else {
			   extentTest.log((Status.FAIL),strValue+" is not entered in "+strdesc);
			   System.out.println("Field is not empty");
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   //method to scroll down
   public void scrollPageDown(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
  }




}