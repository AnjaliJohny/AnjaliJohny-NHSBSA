package com.qa.pageActions;

import java.io.IOException;

import com.qa.pages.NHS_StartPage;

public class NHS_StartPageActions extends NHS_StartPage{

	public NHS_StartPageActions() throws Exception {
		super();
	}	
	
	/* ******************************************************************************************************
	 * Test Name: NHS_StartPageAction
	 * Purpose: This class contains the action of NHS_Start Page
	 * History Created by Anjali Johny
	 * *****************************************************************************************************/
	public NHS_QuestionsPageActions navigateStart() throws Exception {
		Thread.sleep(2000);
		scrollPageDown(driver);
		ClickElement(btnStart, "Start Now Button");
		return new NHS_QuestionsPageActions();
	}
}







