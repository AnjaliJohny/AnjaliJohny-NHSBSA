package com.qa.testCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.Base;

import com.qa.pageActions.NHS_QuestionsPageActions;
import com.qa.pageActions.NHS_StartPageActions;

import com.qa.util.TestUtil;

public class WalesTest extends Base{
	
	NHS_StartPageActions nhs_StartPageActions;
	NHS_QuestionsPageActions nhs_QuestionsPageActions;
	public WalesTest() {
		super();
	}
	
	/* ******************************************************************************************************
	 * Test Name: Wales Test
	 * Purpose: To validate the NHS Cost Checker Tool for Wales Country
	 * History Created by Anjali Johny
	 * *****************************************************************************************************/
	
	@DataProvider
	public Object[][] getNHSCostCheckerTestData(){
		Object data[][]=TestUtil.getTestData("NHSCostChecker");
		return data;
		
	}
	
	
	@Test(dataProvider="getNHSCostCheckerTestData")
	public void validateNHSCostChecker(String scenarioNumber,String day,String month,String year,String partnerStatus,String taxStatus,String universalCreditStatus,String universalCreditDetails,String takehomePay,String pregnantOrgivenbirth,
			String warPensioner,String diabetes,String glaucome,String carehome,String savings,String confirmmsg) throws Exception {
		extentTest=extent.createTest("Verifying NHS Wales Cost Checker----"+ scenarioNumber);
		initialize();
		nhs_StartPageActions=new NHS_StartPageActions();
		extentTest.log(Status.INFO,"NHS Cost Checker Tool Url is: "+prop.getProperty("url"));
		nhs_QuestionsPageActions=nhs_StartPageActions.navigateStart();
		nhs_QuestionsPageActions.validateQuestions(day, month, year,partnerStatus,taxStatus,universalCreditStatus,universalCreditDetails,takehomePay,pregnantOrgivenbirth,warPensioner,diabetes,
				glaucome,carehome,savings,confirmmsg);
	 
	}
}