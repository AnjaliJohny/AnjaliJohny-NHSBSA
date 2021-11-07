package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.GenericFunction;

public class NHS_StartPage extends GenericFunction {
	
	public NHS_StartPage()throws IOException{
		PageFactory.initElements(driver,this);
	}
	/* ******************************************************************************************************
	 * Test Name: NHS_StartPage
	 * Purpose: This class contains all the objects of NHS Start Page
	 * History Created by Anjali Johny
	 * *****************************************************************************************************/
	@FindBy(id="next-button")
	public WebElement btnStart;
	
}